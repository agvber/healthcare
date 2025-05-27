package com.sessac.healthcare.data.utils

import com.sessac.healthcare.common.anontation.ExperimentalFeatureApi
import java.time.LocalDateTime
import kotlin.reflect.KClass
import kotlin.reflect.KParameter
import kotlin.reflect.KType
import kotlin.reflect.full.findParameterByName
import kotlin.reflect.full.isSubclassOf
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.jvm.jvmErasure

class FileParsingUtil {

    fun parseToObj(value: String): Map<String, Any?> {
        val result: MutableMap<String, String> = mutableMapOf()
        value.removePrefix("<")
            .removeSuffix("/>")
            .split(",")
            .forEach { keyWithValue ->
                val keyWithValueSplit: List<String> = keyWithValue.split(":")
                val key: String = keyWithValueSplit[0].drop(1).dropLast(1)
                val value: String = keyWithValueSplit[1].drop(1).dropLast(1)
                result[key] = value
            }
        return result
    }

    @ExperimentalFeatureApi()
    fun <T : Any> parseToObj(value: String, clazz: KClass<T>): T {
        val constructor = clazz.primaryConstructor!!
        val objMap: Map<KParameter, Any?> =
            value.removePrefix("<")
                .removeSuffix("/>")
                .split(",")
                .associate { keyWithValue: String ->
                    val keyWithValueSplit: List<String> = keyWithValue.split(":")
                    val key: String = keyWithValueSplit[0].drop(1).dropLast(1)
                    val value: String? = runCatching { keyWithValueSplit[1].drop(1).dropLast(1) }.getOrNull()
                    val parameter = constructor.findParameterByName(key)
                    parameter!! to value?.let { convertStringToType(it, parameter.type) }
                }
        return constructor.callBy(objMap)
    }

    private fun convertStringToType(value: String, type: KType): Any? {
        val kClass = type.jvmErasure

        return when (kClass) {
            String::class -> value
            Int::class -> value.toIntOrNull()
            Long::class -> value.toLongOrNull()
            Double::class -> value.toDoubleOrNull()
            Float::class -> value.toFloatOrNull()
            Boolean::class -> value.toBooleanStrictOrNull()
            Short::class -> value.toShortOrNull()
            Byte::class -> value.toByteOrNull()
            Char::class -> value.singleOrNull()
            else -> {
                // Enum 처리
                if (kClass.isSubclassOf(Enum::class)) {
                    kClass.java.enumConstants?.firstOrNull { (it as Enum<*>).name == value }
                } else {
                    value
                }
            }
        }
    }


    fun formatString(map: Map<String, Any?>): String {
        val stringBuilder: StringBuilder = StringBuilder("<")

        map.forEach { (key, value) ->
            require(checkPossibleString(key))
            val value = value.toString()
            require(checkPossibleString(value))
            stringBuilder.append("\"$key\":\"$value\",")
        }
        stringBuilder.deleteAt(stringBuilder.length - 1)
        stringBuilder.append("/>")

        return stringBuilder.toString()
    }

    fun <T : Any> formatString(obj: T): String {
        val stringBuilder: StringBuilder = StringBuilder("<")
        val clazz: KClass<T> = obj::class as KClass<T>
        clazz.memberProperties.forEach { prop ->
            val key = prop.name
            val value = when (val propValue = prop.get(obj)) {
                is LocalDateTime -> propValue.format(fileDateFormat)
                else -> propValue.toString()
            }
            require(checkPossibleString(key)) { "사용 불가능한 문자열 포함" }
            require(checkPossibleString(value)) { "사용 불가능한 문자열 포함" }
            stringBuilder.append("\"${key}\":\"${value}\",")
        }

        stringBuilder.deleteAt(stringBuilder.length - 1)
        stringBuilder.append("/>")

        return stringBuilder.toString()
    }

    private fun checkPossibleString(value: String): Boolean {
        return !value.run { contains(':') || contains(',') }
    }
}
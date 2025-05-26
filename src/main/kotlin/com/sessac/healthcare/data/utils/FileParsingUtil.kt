package com.sessac.healthcare.data.utils

import com.sessac.healthcare.common.anontation.ExperimentalFeatureApi
import java.time.LocalDateTime
import kotlin.collections.associateWith
import kotlin.reflect.KClass
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

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
    // ToDo: parameters type check 문제가 존재 해결 할 것
    fun <T : Any> parseToObj(value: String, clazz: KClass<T>): T? {
        val valueMap: Map<String, Any?> = parseToObj(value)
        val constructor = clazz.primaryConstructor ?: return null
        val args = constructor.parameters.associateWith { kParameter ->
            val arg = valueMap[kParameter.name]
            when (kParameter.type.classifier) {
                Int::class -> arg.toString().toInt()
                Double::class -> arg.toString().toDouble()
                Float::class -> arg.toString().toFloat()
                Long::class -> arg.toString().toLong()
                String::class -> arg.toString()
                else -> value
            }
        }
        return constructor.callBy(args)
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
package com.sessac.healthcare.data.utils

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.util.*

val fileDateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH.mm.ss", Locale.KOREA)

fun String.toLocalDateTime(): LocalDateTime {
    val formatter = DateTimeFormatterBuilder()
        .appendPattern("yyyy-MM-dd[ ][H:mm][ ][HH:mm][ ][HH:m][ ][H:m]")
        .toFormatter()
        .withLocale(Locale.KOREA)
    return LocalDateTime.parse(this.trim(), formatter)
}

package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.util.*
import java.text.SimpleDateFormat

fun Date.format(pattern:String = "HH:mm:ss dd.MM.yy"): String{
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR


fun Date.add(value:Int, units:String):Date {

    var time = this.time
    time += when(units) {
        "second", "seconds" -> value * SECOND
        "minute", "minutes" -> value * MINUTE
        "hour", "hours" -> value * HOUR
        "day", "days" -> value * DAY
        else -> throw IllegalStateException("invalid unit")
    }
        this.time = time
        return this
}
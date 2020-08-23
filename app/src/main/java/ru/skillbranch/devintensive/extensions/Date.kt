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


fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time

    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }

    this.time = time
    return this
}

enum class TimeUnits {
    SECOND,
    MINUTE,
    HOUR,
    DAY;

//    TimeUnits.SECOND.plural(1) //1 секунду
//    TimeUnits.MINUTE.plural(4) //4 минуты
//    TimeUnits.HOUR.plural(19) //19 часов
//    TimeUnits.DAY.plural(222) //222 дня


    fun plural(time: Int): String {
        return when (time % 10) {
            1 -> {
                return when (this.name) {
                    SECOND.name -> "$time секунду"
                    MINUTE.name -> "$time минуту"
                    HOUR.name -> "$time час"
                    else -> "$time день"
                }
            }
            in 2..4 -> {
                return when (this.name) {
                    SECOND.name -> "$time секунды"
                    MINUTE.name -> "$time минуты"
                    HOUR.name -> "$time часа"
                    else -> "$time дня"
                }
            }

            else -> {
                return when (this.name) {
                    SECOND.name -> "$time секунд"
                    MINUTE.name -> "$time минут"
                    HOUR.name -> "$time часов"
                    else -> "$time дней"
                }
            }
        }
    }
}
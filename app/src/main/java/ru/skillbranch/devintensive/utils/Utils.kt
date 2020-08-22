package ru.skillbranch.devintensive.utils

import ru.skillbranch.devintensive.models.User

object Utils {

    fun parsFullName(fullName: String?): Pair<String?, String?>{
        val parts : List<String>? = fullName?.split(" ")

        val firstName = if(parts?.getOrNull(0).isNullOrEmpty()) null else parts?.getOrNull(0)
        val lastName = if(parts?.getOrNull(1).isNullOrEmpty()) null else parts?.getOrNull(1)
        return firstName to lastName
    }
}
package ru.skillbranch.devintensive.models

import java.util.*

data class User(
    val id : String,
    var firstName : String?,
    var lastName : String?,
    var avatar : String?,
    var rating : Int = 0,
    var respect : Int = 0,
    var lastVisit : Date? = Date(),
    var isOnline : Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null)

    init {
        println("User's name id is $firstName $lastName")
    }

    companion object Factory{
                private  var lastID : Int = -1
                fun makeUser(fullName : String?) : User{
                    lastID++
                    var parts : List<String>? = fullName?.split(" ")
                    var firstName = parts?.getOrNull(0)
                    var lastName = parts?.getOrNull(1)
                    return User(id = "$lastID", firstName = firstName, lastName = lastName)
                }
    }
}
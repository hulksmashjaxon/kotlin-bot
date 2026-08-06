package org.example.learning.intermediate

/* In kotlin, you can use **object declarations** to declare a class with a single instance. In a sense, you declare the class and create the single instance **at the same time.**
* Object declarations are useful when you want to create a class to use as a single reference point for your program or to coordinate behavior across a system
*
* Objects in Kotlin are lazy, meaning they are only created when accessed. Kotlin also ensures that all objects are created in a thread-safe manner so that you don't have to check this manually.
* */

object DoAuth {
    fun takeParams(username: String, password: String) {
        println("input Auth paramets = $username:$password")
    }
}

data object AppConfig {
    var appName: String = "My Application"
    var version: String = "1.0.4"
}

class BigBen {
    companion object Bonger { // Companion objects are called directly on the class (like BigBen.getBongs()) and don't require you to use the BigBen() syntax to first assign it to a variable
        fun getBongs(nTimes: Int) {
            repeat(nTimes) { print("Bong ") }
        }
    }
}

fun main() {
//    DoAuth.takeParams("jxson", "jxsonIsSoCool")
    println(AppConfig) // "AppConfig"
    println(AppConfig.appName) // "My application"
    BigBen.getBongs(4)
}

/* Class vs object
* Classes are a blueprint for creating many separate instances, whilst an object is a blueprint for a single, unique instance (singleton)
* Classes require manual instantiation (Car()) while objects get automatically instantiated
* Classes are created lazily whenever you call the constructor, while objects are created lazily upon first access
* Classes can have primary and secondary constructors, while objects cannot have constructors
* */
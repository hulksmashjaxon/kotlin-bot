package org.example.learning

fun main() {
    val name = "Kotlin"
    println("Hello, $name!")
    var mutable = "hi"
    mutable = "Var is for mutable variables, and val is for readonly variables!"
    println(mutable)
    for (i in 1..5) {
        println("i = $i")
    }
}
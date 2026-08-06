package org.example.learning.intermediate

fun String.bold(): String = "<b>$this</b>"

fun main() {
    println("hello".bold())
}
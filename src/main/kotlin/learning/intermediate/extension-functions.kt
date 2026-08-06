package org.example.learning.intermediate

import java.net.http.HttpResponse

fun String.bold(): String = "<b>$this</b>"

fun main() {
    println("hello".bold())
}
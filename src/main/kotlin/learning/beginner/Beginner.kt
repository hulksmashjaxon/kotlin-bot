package org.example.learning.beginner

import kotlin.random.Random

class Beginner {
    fun collections() {
        val readOnlyShapes: List<String> = listOf("triangle", "square", "circle")
        println(readOnlyShapes)

        val shapes: MutableList<String> = mutableListOf("triangle", "square", "circle")
        shapes.add("rhombus")
        shapes.remove("triangle")
        println(shapes)
        // val just means it cannot be reassigned, but you can add things using .add()
        println("rhombus" in shapes) //in checks if something is in there

        /* Sets
        *  Sets are unordered and ONLY store unique items.
        *  Lists are ordered and allow duplicate items.
        * */

        val readOnlyFruit = setOf("apple", "banana", "cherry") // Adding a duplicate will only keep one
        val fruit : MutableSet<String> = mutableSetOf("apple", "banana", "cherry")
        fruit.add("melon")
        val finalFruit: Set<String> = fruit // this makes it so fruit is copied to finalFruit and is immutable, also applicable on Lists and Maps
        println(readOnlyFruit)
        println(finalFruit)
        println("The set fruit has ${finalFruit.count()} fruit")

        /* Maps
        * Maps store items as key-value (KV) pairs.
        * Every key in the map must be unique.
        * You can have duplicate values in a map.
        * */

        val readOnlyJuiceMenu = mapOf("apple" to 100, "kiwi" to 190, "orange" to 100)
        println(readOnlyJuiceMenu)
        val juiceMenu = mutableMapOf("apple" to 100, "kiwi" to 190, "orange" to 190)
        juiceMenu["coconut"] = 150
        println("The value of apple juice is: ${juiceMenu["apple"]}")
        println(juiceMenu["coconut"])
        println(juiceMenu.containsKey("coconut"))
        println("""Keys: ${readOnlyJuiceMenu.keys}
            |Values: ${readOnlyJuiceMenu.values}
        """.trimMargin())
        // The 'in' operator is supported. Ex:
        // println("orange" in readOnlyJuiceMenu)
        // println(200 in readOnlyJuiceMenu.values)
        // however, the containsKey and containsValue methods do the same thing
    }

    fun controlFlow() {
        val d: Int // this Val modifiable until assigned a value
        val check = true
        // you could write this as if (check) { d = 1 } else { d = 2 }, but this is simpler and easier to understand
        d = if (check) {
            1
        } else {
            2
        }
        println(d)

        /* When statements
        * Use when when you have a conditional expression with multiple branches.
        * Jetbrains recommends using when over if in most cases.
        */

        var obj = "N/A"
        val options = listOf("1", "Hello", "No")
        obj = options.random()

        when (obj) {
            "1" -> println("1")
            "Hello" -> println("Hello")
            else -> println("N/A")
        }
        /* You can also use when as an expression.
        val result = when(obj) {
        "1" -> "One"
        "Hello" -> "Greeting"
        else -> "Unknown"
        }
        result will be equal to "One", "Greeting", or "Unknown"
         */

        val trafficLightState = "Red"
        val trafficAction = when (trafficLightState) {
            "Green" -> "Go"
            "Yellow" -> "Slow down"
            "Red" -> "Red"
            else -> "Malfunction"
        }

        // Examples

        val first = Random.nextInt(6)
        val second = Random.nextInt(6)
        if (first == second) {
            println("You win :)")
        } else {
            println("You lose :(")
        }
        val button = "A"
        println(when (button) {
            "A" -> "Yes"
            "B" -> "No"
            "X" -> "Menu"
            else -> "N/A"
        })

        // Ranges, using the .. operator, ..< to exclude the end value
        println('a'..'d') // -> equivalent to 'a', 'b', 'c', 'd'
        println('z' downTo 's') // -> goes down from Z to S
        println('z' downTo 's' step 2) // goes down to S in 2 step increments, eqv to 'z', 'x', 'v', 't'
        // Loops
        for (number in 1..5) {
            print(number) // 12345
        }
        val cakes = listOf("carrot", "cheese", "chocolate")
        for (cake in cakes) {
            println("Yummy, it's a $cake cake!")
        }

        var cakesEaten = 0
        var cakesBaked = 0
        while (cakesEaten < 3) { // checks the condition first, THEN runs
            println("eat a cake")
            cakesEaten++
        }

        do {
            println("Bake a cake")
            cakesBaked++
        } while (cakesBaked < cakesEaten)

    }
}

fun main() {
    val beginner = Beginner()
//    beginner.collections()
    beginner.controlFlow()
}
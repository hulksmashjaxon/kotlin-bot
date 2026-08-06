package org.example.learning.intermediate

/* If you can't use interfaces or abstract classes, you can explicitly make a class inheritable by declaring it as `open`.
*
* */

open class Vehicle(val make: String, val model: String) {
    open fun displayInfo() { // open means it can be overridden
        println("Vehicle Info: Make - $make, Model - $model")
    }
}
class Car(make: String, model: String, val numberOfDoors: Int): Vehicle(make, model) {
    override fun displayInfo() {
        println("Car info: $model, $make | $numberOfDoors door")
    }
}

interface EcoFriendly {
    val emissionLevel: String
}

interface ElectricVehicle {
    val batteryCapacity: Double
}

open class Vehicle2(val make: String, val model: String)
open class Car2(make: String, model: String, val numberOfDoors: Int) : Vehicle(make, model)
class ElectricCar(make: String, model: String, numberOfDoors: Int, val capacity: Double, val emission: String) : Car2(make, model, numberOfDoors), EcoFriendly, ElectricVehicle {
    override val emissionLevel: String = emission
    override val batteryCapacity: Double = capacity
}

enum class ColourToHex(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0xFFFF00)
}


fun main() {
    val car = Car("Toyota", "Corolla", 4)
    car.displayInfo()
}

/*
* In Kotlin, it's not common practice to make a property inheritable by using the open keyword and overriding it later.
* Most of the time, you use an abstract class or an interface where properties are inheritable by default.
* */
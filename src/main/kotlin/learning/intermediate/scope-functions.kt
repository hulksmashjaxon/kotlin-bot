package org.example.learning.intermediate

fun sendNotification(address: String) {
    println("sent notification to $address")
}

fun getNextAddress(): String {
    return "jaxon@jxson.tech"
}

class Client {
    var token: String? = null
    var clientParams: Map<String, Boolean>? = null
    fun connect() = println("connected!")
    fun authenticate() = println("authenticated!")
    fun getData(): String {
        println("getting data..")
        return "Mock data"
    }
}

class Canvas {
    fun rect(x: Int, y: Int, w: Int, h: Int): Unit = println("$x, $y, $w, $h")
    fun circ(x: Int, y: Int, rad: Int): Unit = println("$x, $y, $rad")
    fun text(x: Int, y: Int, str: String): Unit = println("$x, $y, $str")
}

fun main() {
    val address: String? = getNextAddress()
    address?.let {
        sendNotification(it) //.let() will only run if something is not null. "it" refers to the non null string
    }
    val client: Client = Client().apply {
        token = "1234"
        clientParams = mapOf("is_v2" to true, "is_usr_capable" to true)
        // instead of doing a bunch of token = "xxxx" and connect() in the side, you can do them all at once using .apply()
    }
    val result: String = client.run {
        connect()
        authenticate() // runs these functions/setters first, then returns the final returned value of the last function (getData())
        getData()
    }
    val medals: List<String> = listOf("Gold", "Silver", "Bronze")
    val reversedLongUppercaseMedals: List<String> = medals.map { it.uppercase() }
        .also { println(it) } // "also" scope function completes an additional action with an object then returns the object
        .filter { it.length > 4 }
        .also { println(it) }
        .reversed()
    println(reversedLongUppercaseMedals) // [BRONZE, SILVER]

    val mainMonitorPrimaryBufferBackedCanvas = Canvas()
    with(mainMonitorPrimaryBufferBackedCanvas) { //.with() calls multiple functions on an object
        text(10, 10, "Foo")
        rect(20, 30, 100, 50)
        circ(40, 60, 25)
        text(15, 45, "Hello")
        rect(70, 80, 150, 100)
        circ(90, 110, 40)
        text(35, 55, "World")
        rect(120, 140, 200, 75)
        circ(160, 180, 55)
        text(50, 70, "Kotlin")
    }
}
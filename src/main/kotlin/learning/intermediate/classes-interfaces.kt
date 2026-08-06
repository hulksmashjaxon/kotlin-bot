package org.example.learning.intermediate

/*
* abstract classes can be inherited by default. the purpose of abstract classes is to provide members that other classes inherit or implement.
* as a result, they have a constructor but you can't create instances from them. within the child class, you define the behavior of the parent's properties with the `override` kyerowrd.
* in this way, you can say that the child class "overrides" the members of the parent class.
* */
abstract class Product(val name: String, var price: Double) {
    abstract val category: String
    fun productInfo(): String {
        return "Product: $name | Category: $category | Price: $price"
    }
}

class Electronic(name: String, price: Double, val warranty: Int = 1) : Product(name, price) { // inherits from the Product abstract
    override val category = "Electronic"
}
/*
* Interfaces are similar to classes, but with some differences:
* * You can't create an instance of an interface- no constructor or header
* * Their functions and properties are implicitly inheritable by default. In kotlin terms, that is called "open"
* * You don't need to mark their functions as `abstract` if you don't give them an implementation.
*
* Similar to abstract classes, you use interfaces to define a set of functions and properties that classes can inherit and implement later. Using interfaces makes code:
* * More modular, as it isolates different parts, allowing them to evolve independently
* * Easier to understand by grouping related functions into a cohesive set
* * Easier to test, as you can quickly swap an implementation with a mock for testing
* */

interface PaymentMethod {
    fun initiatePayment(amount: Double): String
    /* Interfaces support multiple inheritance so a class can implement multiple interfaces at once */
}
    interface PaymentType {
        val paymentType: String
    }

    class CreditCardPayment(val cardNumber: String, val cardHolderName: String, val expiryDate: String): PaymentMethod, PaymentType {
    override fun initiatePayment(amount: Double): String {
        return "Payment of $$amount initiated using Credit Card ending in ${cardNumber.takeLast(4)}"
    }

    override val paymentType = "CreditCardPayment"
}

/* Interfaces are useful, but if your interface contains many functions, its child classes can end up with a fuck ton of boilerplate code.
* If you only want to override a small part of a class's behavior, you need to repeat yourself a lot. */

interface DrawingTool {
    val color: String
    fun draw(shape: String)
    fun erase(area: String)
    fun getToolInfo(): String
}


fun main() {
    val laptop = Electronic(name = "Laptop", price = 999.99, warranty = 2)
    println(laptop.productInfo()) // prints: Product: Laptop | Category: Electronic | Price: 999.99 because the fun productInfo was inherited
    /*
    * abstracts are great for sharing code, but they are restricted because classes can only support single inheritance.
    * if you need to inherit from multiple sources, use interfaces.
    * */
    // Interfaces
    val paymentMethod = CreditCardPayment("1234 5678 9012 3456", "John Placeholder", "12/25")
    println(paymentMethod.initiatePayment(150.00))
    println("Payment by: ${paymentMethod.paymentType}")
}
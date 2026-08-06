package org.example.learning.intermediate

data class MenuItem(val name: String)
class Menu(val name: String) {
    val items = mutableListOf<MenuItem>()
    fun item(name: String) {
        items.add(MenuItem(name))
    }
}

fun printMenu(menu: Menu) {
    println("Menu: ${menu.name}")
    menu.items.forEach { println("Item: ${it.name}") }
}

fun menu(name: String, init: Menu.() -> Unit): Menu { // Menu.() -> Unit is a lambda wit a receiver. the receiver is Menu
    val menu = Menu(name) // Creates menu
    menu.init() // runs block (translates to menu.item("whateverWasPassed"))"
    return menu
}

fun main() {
    val mainMenu = menu("Main Menu") { // 'this' or the receiver is equal to Menu, so any functions from Menu wil work here. the items get created because of item() function. also, if a lambda is the last param you can use brackets outside
        item("Home") // these are the params for .init()
        item("Settings")
        item("Exit")
    }
    printMenu(mainMenu)
}
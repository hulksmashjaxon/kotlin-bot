package org.example.learning.classes
import kotlin.uuid.Uuid

class Contact(val id: Int, var email: String) {
    val category: String = "work"
    fun printId() {
        println(id) // there is no other "id" variable in this code, so we can just print id instead of this.id. you can use this.id when there's another variable with the same name
    }
}

data class User(val name: String, val id: Int)
data class Information(var address: String, val phoneNumber: Long, val workEmail: String)
data class Employee(val name: String, var salary: Int, val employeeId: Uuid, var personalInformation: Information)
class Company(val name: String, val address: String, val employees: MutableList<Employee>) {
    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }
    fun getEmployee(employeeId: Uuid): Employee? {
        val employee = employees.find { it.employeeId == employeeId }
        if (employee == null) return null;
        return employee
    }
    fun changeEmployeeInformation(employeeId: Uuid, newInformation: Information) {
        val employee = employees.find { it.employeeId == employeeId }
        employee?.personalInformation = newInformation
    }
}


fun main() {
    val contact = Contact(1, "jaxon@jxson.tech")
    println("${contact.id} ${contact.email}")
    contact.printId()
    val user = User("jaxon", 1)
    println(user) // Printing data classes will output readable text, in this case User(name="jaxon", id=1)
    println(user.copy(name = "Jaxon but copied", id = 2)) // using .copy() will create a copy of the data class
    val employee = Employee(name = "Jaxon", salary = 400, employeeId = Uuid.random() ,personalInformation = Information("1234 84th Dr", 1234567890, workEmail = "jaxon@jxson.tech"))
    val company = Company(name = "jxson co", address = "1234 84th Dr", employees = mutableListOf(employee))
    company.changeEmployeeInformation(employeeId = employee.employeeId, newInformation = Information(address = "1284 N Corona Ct", phoneNumber = 6843891234, workEmail = "jaxon@jxson.tech"))
    println(company.employees)
}

// Elvis operator "?." will return a default value if it's a null value
// Ex: val nullstr: String = null; println(nullstr?.length ?: 0)
package app

import scala.io.StdIn

abstract class BankAccount(accountNumber : String, val balance : Double) {

  def withdraw(amount: Double) : BankAccount

  def deposit(amount: Double) : BankAccount

}

final class SavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance - amount)

  override def deposit(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance + amount)

}

class Person(name : String, age : Int) {

  private val years : String = if(age == 1) "year"
  else "years"

  def speak(): String = {

    if (name.toLowerCase() == "adam") {

      "You don't get a hello"

    }

    else {

      s"Hello $name you are $age $years old."

    }
  }
}

object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)

}

  object GreeterApplication extends App {

    val savingsAccount = new SavingsAccount("12345", 100.00)
    val savingsPlus100 = savingsAccount.deposit(50.00)

    println(savingsAccount.balance)
    println(savingsPlus100.balance)

    val name = Prompt.ask("What is your name? ")

    val age = Prompt.ask("What is your age? ")

    val p = new Person(name, age.toInt)

    println(p.speak())

}


package app

import scala.io.StdIn

abstract class BankAccount(accountNumber : String, val balance : Double) {

  def withdraw(amount: Double) : BankAccount

  def deposit(amount: Double) : BankAccount

}

final class SavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {

    if ((balance - amount) < 0) {

      println(s"You have insufficient funds.")
      this
      } else {

      val deducted = balance - amount
            println(s"Balance after deductions: $deducted.")
      new SavingsAccount(accountNumber, deducted)
    }
  }
  override def deposit(amount: Double): BankAccount = new SavingsAccount(accountNumber, balance + amount)
}

final class CashISASavingsAccount(accountNumber: String, balance: Double) extends BankAccount(accountNumber, balance) {

  override def withdraw(amount: Double): BankAccount = {

    println(s"You can't withdraw yet, your money is locked in for 3 years.")
    this
    }
    override def deposit(amount: Double): BankAccount = {

      new CashISASavingsAccount(accountNumber, balance + amount)

    }

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

    val cashISASavingsAccount = new CashISASavingsAccount("67890", 100.00)
    //val cashISAPlus100 = cashISASavingsAccount.deposit(50.00)
    val cashISAMinus100 = cashISASavingsAccount.withdraw(50.00)

    //println(savingsAccount.balance)
    //println(savingsPlus100.balance)

    println(cashISASavingsAccount.balance)
    println(cashISAMinus100.balance)

    val name = Prompt.ask("What is your name? ")

    val age = Prompt.ask("What is your age? ")

    val p = new Person(name, age.toInt)

    //println(p.speak())

}


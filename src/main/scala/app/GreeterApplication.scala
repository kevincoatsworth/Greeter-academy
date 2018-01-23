package app

import scala.io.StdIn

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

    val name = Prompt.ask("What is your name? ")

    val age = Prompt.ask("What is your age? ")

    val p = new Person(name, age.toInt)

    println(p.speak())

}


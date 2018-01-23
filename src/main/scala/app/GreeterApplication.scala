package app

import scala.io.StdIn

class Person(name : String) {

  def speak(): String = {

    if (name.toLowerCase() == "adam") {

      "You don't get a hello"

    }

    else {

      "Hello " + name

    }
  }
}

object Prompt {

  def ask(message : String) : String = StdIn.readLine(message)

}

  object GreeterApplication extends App {

    val name = Prompt.ask("What is your name ")

    val p = new Person(name)

    println(p.speak())

}


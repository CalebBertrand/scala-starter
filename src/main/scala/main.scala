@main def main(): Unit =
  sealed trait Person {
    val name: String = "Generic Name"
  }
  case class Chef(override val name: String) extends Person
  case class Citizen() extends Person

  val myPerson = Chef("John")
  val myGenericPerson = Citizen()

  def sayPersonName[T <: Person](person: T): Unit =
    println("Hello, my name is " ++ person.name)

  sayPersonName(myPerson)
  sayPersonName(myGenericPerson)


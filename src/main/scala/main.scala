@main def main(): Unit =
  sealed trait Person {
    val name: String = "Generic Name"
  }
  case class Chef(override val name: String) extends Person
  case class Citizen() extends Person

  def sayPersonName[T <: Person](person: T): Unit =
    println("Hello, my name is " ++ person.name)

  val citizens = Vector(Chef("James"), Citizen(), Citizen(), Citizen())

  // for comprehension
  for citizen <- citizens if citizen.name == "James" do sayPersonName(citizen)

  // Bad practice, an example of infix notation
  citizens.filter(_.name == "James") foreach sayPersonName

  // Pattern matching
  for citizen <- citizens do citizen.name match
    case "James" => sayPersonName(citizen)
    case _ => // Don't print

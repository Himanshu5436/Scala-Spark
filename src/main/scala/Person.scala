import org.apache.spark._;
//import org.apache.spark.sql.types._;
class person {

  var crustSize = 12
  var crustType = "Thin"

  def this(crustSize: Int) {
    this()
    this.crustSize = crustSize
  }

  def this(crustSize: Int, crustType: String) {
    this(crustSize)
    this.crustType = crustType
  }

  override def toString = {
    "A %s inch pizza with %s crust.".format(crustSize, crustType)
  }

}

object AuxiliaryConstructors extends App {
  println(new person)
  println(new person(14))
  println(new person(16, "Thick"))

  val schemaString = "id name age"
}
/*
/**
  * Created by Himanshu on 25-03-2017.
  */
case class Person(private var firstName: String , val  lastName : String, val age: Int) {
  var fame: String  = _
  val k = ("himanshu",2,3,4,5)
  val tup = new Tuple2(1,2)
  val tup3 =  new Tuple3(1,2,3)
      k._3

  def him = {

  }
  val(name, aged, weight) = ("Al", 42, 200.0)
  name
  /*def this(firstName: String) {
    this(firstName, "%%%", 0);
    println("\nNo last name or age given.")
  }

  /**
    * Another secondary constructor.
    */
  def this(firstName: String, lastName: String) {
    this(firstName, lastName, 0);
    println("\nNo age given.")
  }
*/
  def printFirstName = {
    print("my firstbae" + firstName)
  }
  override def toString: String = {
    return "%s %s %d".format(firstName, lastName, age)
  }

}
object himanshu{
  def main(args: Array[String]): Unit = {


  val p1 = new Person("himanshu rawat","fff",3)
    //p1.firstName = "Himanshu Rawat"
   // p1.lastName = "bhaisaas"
    //println("")
      p1.printFirstName
    println(p1)
  }}
*/

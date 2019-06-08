/**
  * Created by Himanshu on 26-03-2017.
  */
class myPerson {
  var name: String = _
  var age: Int = _

  override def toString = {
    "A %s inch pizza with %s crust.".format(name, age)
  }

}

object myPerson {
  def apply(name: String,age : Int): myPerson = {
    var p = new myPerson
    p.name = name
    p.age = age
    p
  }
}
object acess{
  def main(args: Array[String]): Unit = {
    val m = myPerson("himanshu",67)
    val k = myPerson
    print(m +"and"+k)
  }
}

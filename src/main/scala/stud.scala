/**
  * Created by Himanshu on 27-03-2017.
  */
class stud {
var name : String = _
}
object stud {
def apply(stud : String) : stud = {
 val stude = new stud
  stude.name =stud
  stude
}

}

object my {
  def main(args: Array[String]): Unit = {
    val k = stud
    print(k)
  }
}

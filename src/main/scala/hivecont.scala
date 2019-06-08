/**
  * Created by Himanshu on 29-03-2017.
  */
object hivecont extends App {
  def Adjective(s:String): Unit ={
    println((scala.util.Try(s.toLong).isSuccess))
    if(!(scala.util.Try(s.toLong).isSuccess)){
      println("false")
    }
  }
  Adjective("123")
}

import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.expressions.Window
import org.apache.spark.sql.expressions.Window
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.hive.HiveContext
/**
  * Created by Himanshu on 19-05-2019.
  */
case class Employee(emp_id : Int, firstName : String, empLastName : String, Dept_id : Int)
case class Salary(emp_id : Int, salary : Int)
object interviewUS {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:/Users/Himanshu/Downloads/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/");
    val conf = new SparkConf().setAppName("My first scala").setMaster("local")
    val sc = new SparkContext(conf)
    val sq = new SQLContext(sc)
    val sql = new HiveContext(sc)
    import sql.implicits._
    val employees = Seq(Employee(1, "Himanshu", "Rawat", 3),
      Employee(2, "Hima", "Rawat", 2),
      Employee(3, "Himan", "Rawat", 3),
      Employee(4, "Himans", "Rawat", 1),
      Employee(5, "Himansu", "Rawat", 1)).toDF


    val salary = Seq(Salary(1, 2000),
      Salary(2, 300),
      Salary(3, 40),
      Salary(4, 5000),
      Salary(5, 7000)).toDF
    employees.show(100,false)
    salary.show(200,false)
    val win = Window.partitionBy("Dept_id").orderBy("salary")
    employees.join(salary,Seq("emp_id"),"left").withColumn("avg", avg("salary") over win).show()
  }
}
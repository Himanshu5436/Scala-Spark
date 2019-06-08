/**
  * Created by Himanshu on 04-03-2017.
  */
import com.typesafe.config._
import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions.{col, concat, concat_ws, lit}
import org.apache.spark.sql.functions._
import org.apache.spark.sql.{DataFrame}
object total_revenue {
  def main(args: Array[String]) {
    //System.setProperty("hadoop.home.dir", "C:/Users/Himanshu/Downloads/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/")
    val props = ConfigFactory.load("application.properties")
    val conf = new SparkConf().setAppName("joining order items to get the total revenue from the order items").setMaster(props.getString(args(0)))
    val sc = new SparkContext(conf)
    //println(props.getString("dev.executionmode"))
    //val orders = sc.textFile("C:/Users/Himanshu/Desktop/data-master/retail_db/orders/part-00000")
    val orders = sc.textFile(args(1))
    val order_items = sc.textFile(args(2))
    //val order_items = sc.textFile("C:/Users/Himanshu/Desktop/data-master/retail_db/order_items/part-00000")
    val ordersfilter = orders.filter(res => (res.split(",")(0)!= 685 && res.split(",")(3)== "CLOSED"||(res.split(",")(3)== "COMPLETE"))).
      map(res => (res.split(",")(0),res.split(",")(1)))
    val orderitemsfilter = order_items.filter(res => res.split(",")(1)!= 685).map(res => (res.split(",")(0),res.split(",")(4).toFloat))
    val joinr = ordersfilter.join(orderitemsfilter).map(res => (res._2._1,res._2._2))
    // Reduce by key logic
    //val totalrevenue = joinr.reduceByKey((val1,val2)=> val1+val2)
    //group by key
    val totalrevenue = joinr.groupByKey().map(m => (m._1,m._2.sum))
    totalrevenue.saveAsTextFile(args(3))
  }
}
object him extends App {
  System.setProperty("hadoop.home.dir", "C:/Users/Himanshu/Downloads/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/")
  val props = ConfigFactory.load("application.properties")
  val conf = new SparkConf().setAppName("joining order items to get the total  from the order items").setMaster("local")
  val sc = new SparkContext(conf)
  sc.setLogLevel("ERROR")
  val sql = new SQLContext(sc)

  import sql.implicits._
println("=============================================================================================================================================================>")
  val df = sc.parallelize((List(("himanshu", "rawat", "1223"), ("Bob", "rawat", "1203")))).toDF("n", "d", "e")
  df.select(
    col(df.columns(0)),
    col(df.columns(1)),
    concat(
      lit("{"),
      concat_ws(",", df.dtypes.slice(0, df.dtypes.length).map(dt => {
        val c = dt._1;
        val t = dt._2;
        concat(
          lit("\"" + c + "\":" + (if (t == "StringType") "\""; else "")),
          col(c),
          lit(if (t == "StringType") "\""; else "")
        )
      }): _*),
      lit("}")
    ) as "C"
  ).show(false) //collect().foreach(println)
  // val f = df.columns.map(x => (df(x).alias(x))
  // df.select(f:_*).show(false)
  println(List(1, 2, 3, 4, 5).getClass)
  var count = 0;

  def ab(a: Int, args: String*): Unit = {

    println(args.mkString(","))

  }

  val k = 1
  val b = "k"
  ab(k, b, "c", "g")

  df.select(
    concat_ws(",", df.dtypes.toList.map(dt => {
      println(dt)
      val c = dt._1;
      val t = dt._2;
      concat(
        lit("\"" + c + "\":" + (if (t == "StringType") "\"" else "")),
        col(c),
        lit(if (t == "StringType") "\""; else "")
      )
    }): _*)
  ).show(false)
  val letters = List("a", "b", "b", "a", "c", "d", "d", "d", "b")
  //val m = letters.foldLeft[scala.collection.mutable.Map[String,Int]](scala.collection.mutable.Map.empty)((m, c)
  //=> m + (c -> (m.getOrElse(c, 0) + 1)))
  val k8 = letters.groupBy(identity).mapValues(_.size).toList.map(a => (a._2, a._1))
  letters.groupBy(identity).mapValues(_.size).foreach(println)
  val l = k8.map(a => a._1).max
  println(k8.filter(a => a._1 == l))
  val Input = sc.parallelize(List(("2016", "100", "200", "400"), ("2017", "500", "600", "300"), ("2018", "100", "200", "400"))).toDF("Date", "Q1", "Q2", "Q3")

  def melt(
          df2:DataFrame,
            id_vars: Seq[String], value_vars: Seq[String],
            var_name: String = "variable", value_name: String = "value"): DataFrame = {

    // Create array<struct<variable: str, vlue: ...>>
    val _vars_and_vals = array((for (c <- value_vars) yield {
      struct(col(c).alias(value_name),lit(c).alias(var_name))
    }): _*)

    // Add to the DataFrame and explode
    val _tmp = df2.withColumn("_vars_and_vals", explode(_vars_and_vals))
val cols = id_vars.map(col _) ++ {
      for (x <- List(var_name, value_name)) yield {
        col("_vars_and_vals")(x).alias(x)
      }
    }
return _tmp.select(cols: _*)
}
melt(Input,Seq("Date"),Seq("Q1","Q2","Q3"),"Column _Name","Column_Values").show()
  def printll(rt : String*): Unit ={
    println(rt)

  }
  printll(Array("himanshui","rawat"):_*)
}
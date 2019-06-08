/*
import com.typesafe.config.ConfigFactory
import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by Himanshu on 29-03-2017.
  */
object JuzzPractise {
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
    val ordersfilter = orders.filter(res => (res.split(",")(0) != 685 && res.split(",")(3) == "CLOSED" || (res.split(",")(3) == "COMPLETE"))).
      map(res => (res.split(",")(0), res.split(",")(1)))
    val orderitemsfilter = order_items.filter(res => res.split(",")(1) != 685).map(res => (res.split(",")(0), res.split(",")(4).toFloat))


  }
}
*/

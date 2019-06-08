import com.typesafe.config.ConfigFactory
import org.apache.spark.{SparkConf, SparkContext}

import scala.collection.mutable.ListBuffer

/**
  * Created by Himanshu on 07-05-2017.
  */
object ElectionCommicion {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:/Users/Himanshu/Downloads/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/")
    //val props = ConfigFactory.load("application.properties")
    val conf = new SparkConf().setAppName("joining order items ").setMaster("local")
    val sc = new SparkContext(conf)

    //println(props.getString("dev.executionmode"))
    //val orders = sc.textFile("C:/Users/Himanshu/Desktop/data-master/retail_db/orders/part-00000")

    //val orders = sc.textFile(args(1))
    val fileContents = sc.
      textFile("C:/Users/Himanshu/Desktop/election.txt")
    val upData = fileContents.filter(_.split("\t")(0) == "Uttar Pradesh")
    val list = new ListBuffer[(String,Int)]
    //list += (("him",5))
    val upDataMap = upData.
      map(rec =>
      {
        val r = rec.split("\t")
        ((r(0), r(1)), (r(6), r(8).toInt))
      })
    val k = upDataMap.groupByKey().
      map(rec => {
        (rec._1, rec._2.toList.sortBy(s => -s._2))
      })
     k.map(rec => (rec._1,{
      for(i <- rec._2){
        if(i._1 == "INC" || i._1 == "SP") {
          //val k = "Ally"
           list += (("Ally",i._2))

        } else list += ((i._1,i._2))
      }
      println(rec._1)
    })).map(r => r._2).take(5).foreach(println)
    //l.take(5).foreach(println)
     // k.take(5).foreach(println)
  }
}
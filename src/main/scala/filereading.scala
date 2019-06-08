/**
  * Created by Himanshu on 22-02-2017.
  */
import com.typesafe.config._
import org.apache.spark.SparkContext._
import org.apache.spark.{SparkConf, SparkContext}

object filereading {
  def main(args: Array[String]): Unit = {
    System.setProperty("hadoop.home.dir", "C:/Users/Himanshu/Downloads/hadoop-common-2.2.0-bin-master/hadoop-common-2.2.0-bin-master/");
    val conf = new SparkConf().setAppName("My first scala").setMaster("local")
    val sc = new SparkContext(conf)
//sc.
    //val s = new SparkSession
    //val k = sc.textFile(args(0))
   // println(k.first())
    //val l = k.flatMap(x => x.split(","));
    //val counts = l.map(word => (word, 1)).reduceByKey{(x, y) => x + y}
    //counts.saveAsTextFile(args(1))
    val k = sc.parallelize(List("my name is himanshu rawat","my name is khan"))
    val m = k.map(a => {
     val p = a.split(" ")
      println(p.getClass.getSimpleName)
      p
    })
    m.flatMap(a => a).foreach(println)
    val fruits = Array("apple", "banana", "orange")
    k.collect()
    k.count
    //fruits.flatMap(a =>)
  }

}

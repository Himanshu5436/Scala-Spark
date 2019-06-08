name := "wlabs"

version := "1.0"

scalaVersion := "2.10.6"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.36"
libraryDependencies +="com.typesafe" % "config" % "1.3.1"
libraryDependencies +="org.apache.spark" % "spark-core_2.10" % "1.6.2"
libraryDependencies +="org.apache.spark" % "spark-sql_2.10" % "1.6.2"
libraryDependencies +="org.apache.spark" % "spark-streaming_2.10" % "1.6.2"
//libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.6.0"  excludeAll ExclusionRule(organization = "javax.servlet")
//libraryDependencies += "org.apache.hadoop" % "hadoop-common" % "2.6.0"     excludeAll(ExclusionRule(organization = "org.eclipse.jetty"))
libraryDependencies += "org.apache.spark" % "spark-hive_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-streaming-flume_2.10" % "1.6.2"
libraryDependencies += "org.apache.spark" % "spark-streaming-flume-sink_2.10" % "1.6.2"
//libraryDependencies += "com.databricks" % "spark-csv_2.11" % "1.0.3"
libraryDependencies += "com.databricks" % "spark-csv_2.11" % "1.2.0"
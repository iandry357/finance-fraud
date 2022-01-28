package financefraud

import scala.io.Source
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

import org.apache.spark.rdd.RDD

object Hello {
    def main(args: Array[String]) = {
        println("Hello, world")
        val a = 1
        println(a)

        /*val spark = SparkSession.builder()
                .master("local[1]")
                .appName("SparkByExample")
                .getOrCreate();*/

        // val conf: SparkConf = new SparkConf().setAppName("financefraud").setMaster("local")
        val conf: SparkConf = new SparkConf().setAppName("creditcard").setMaster("local")

        val sc: SparkContext = new SparkContext(conf)

        println("First SparkContext:")
        println("APP Name :"+sc.appName);
        println("Deploy Mode :"+sc.deployMode);
        println("Master :"+sc.master);

        /*
        val bufferedSource = io.Source.fromFile("/home/headwork70/Documents/GitProject/fraud-detection/finance-fraud/src/main/resources/finance-fraud/finance-fraud.csv")
        var matrix :Array[Array[String]] = Array.empty
        for (line <- bufferedSource.getLines) {
            val cols = line.split(",").map(_.trim)
            println(line)
            matrix = matrix :+ cols
        }
        bufferedSource.close
        */


        /*
        val rddFromFile = sc.textFile("/home/headwork70/Documents/GitProject/fraud-detection/finance-fraud/src/main/resources/creditcard/creditcard.csv")
        val rdd = rddFromFile.map(f=>{
            f.split(",")
        })

        rdd.collect()
        */

        
        var matrix :Array[Array[String]] = Array.empty
        // val ipfileStream = getClass.getResourceAsStream("/creditcard/creditcard.csv")
        val ipfileStream = getClass.getResourceAsStream("/financefraud/finance-fraud.csv")
        println(ipfileStream)
        val readlines = Source.fromInputStream(ipfileStream).getLines
        // readlines.foreach(readlines => println(readlines))
        val rdd = readlines.foreach(f=>{
            val cols = f.split(",").map(_.trim)
            matrix = matrix :+ cols
        })
        
        println("---> " + matrix.size)
        println(matrix(1))
        
        // rddFromFile.close()
        sc.stop()

    }
}
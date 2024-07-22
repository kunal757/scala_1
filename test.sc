import scala.collection._
object HelloWorld {
  def main(args: Array[String]): Unit = {
    val a=Seq(1 to 10).flatten
    val b=a.map(i=> scala.math.pow(i,2)).reduce(_+_)-scala.math.pow(a.reduce(_+_),2)
    println(b.toLong)
  }
}


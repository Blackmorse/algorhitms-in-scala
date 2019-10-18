package one.three

import edu.princeton.cs.algs4.{Date, StdIn}
import one.two.DateClient


object DatesArray {
  def readDates(): Array[Date] = {

    var input = StdIn.readString()

    val q = new Queue[Date]
    while(input != "end") {
      q.enqueue(DateClient(input))
      input = StdIn.readString()
    }

    q.toArray
  }

  def main(args: Array[String]): Unit = {
    readDates().foreach(println)
  }
}

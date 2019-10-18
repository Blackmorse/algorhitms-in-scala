package one.three

import edu.princeton.cs.algs4.{Date, StdIn}
import one.two.DateClient


object DatesArray {
  def readDates(): Array[Date] = {
    LazyList.continually(StdIn.readString()).takeWhile(_ != "end").map(DateClient(_)).toArray
  }

  def main(args: Array[String]): Unit = {
    readDates().foreach(println)
  }
}

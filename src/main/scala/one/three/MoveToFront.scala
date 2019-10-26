package one.three

import edu.princeton.cs.algs4.StdIn

object MoveToFront {

  def main(args: Array[String]): Unit = {
    val strings = LazyList.continually(StdIn.readString()).takeWhile(_ != "end").toArray

    println(strings)
  }

  def doMove(array: Array[String]): LinkedList[String] = {
    val list = new LinkedList[String]

    for (a <- array) {
      if (list.find(a)) {
        list.remove(a)
      }
      list.addFirst(a)
    }

    list
  }
}

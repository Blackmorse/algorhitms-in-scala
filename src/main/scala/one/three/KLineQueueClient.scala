package one.three

import edu.princeton.cs.algs4.StdIn

object KLineQueueClient {
  def main(args: Array[String]): Unit = {

    val queue = new Queue[String]

    var in = StdIn.readString()
    while (in != "end") {
      queue.enqueue(in)
      in = StdIn.readString()
    }

    val k = StdIn.readInt()

    val iterator = queue.iterator

    1 until k foreach (_ => iterator.next())

    println(iterator.next())
  }
}

package one.three

import edu.princeton.cs.algs4.StdIn

object Josephus {
  def main(args: Array[String]): Unit = {
    val n = StdIn.readInt()
    val m = StdIn.readInt()

    doJosef(n, m).foreach(println)
  }

  def doJosef(n: Int, m: Int): Array[Int] = {
    val queue = new CircularQueue[Int]
    0 until n foreach queue.enqueue

    val iterator = queue.circularIterator()

    LazyList.continually({
        1 until m foreach (_ => iterator.next())
        iterator.remove()
      })
      .take(n).toArray
  }
}

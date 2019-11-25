package two.one

import scala.collection.mutable

class ShellSortArraySequence[T](implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    val n = a.length

    val arrayBuffer= mutable.Buffer[Int]()

    var t = 1
    while(t < n / 3) {
      arrayBuffer += t
      t = 3 * t + 1
    }

    val sequence = arrayBuffer.toArray.reverse

    for (h <- sequence) {
      for (i <- h until n) {
        var j = i
        while (j >= h && less(a(j), a(j -h ))) {
          exch(a, j, j-h)
          j -= h
        }
      }
    }
  }
}

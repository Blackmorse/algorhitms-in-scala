package two.one

import scala.collection.mutable

trait SortAlgorhitm[T] {
//  val drawer: ADrawer[T]
  implicit protected val toOrdered: T => Ordered[T]

  def sort(a: Array[T]): Unit

  protected def less(a: T, b: T): Boolean = a.compareTo(b) < 0

  protected def show(a: Array[T]): Unit = {
    a.foreach(println)
    println()
  }

  def isSorted(a: Array[T]): Boolean = {
    for (i <- 1 until a.length) {
      if(less(a(i), a(i-1))) return false
    }
    true
  }
}

object SortAlgorhitm {
  def check[T](a: Array[T])(implicit toOrdered: T => Ordered[T]): Boolean = {

    var h = 1
    var buf = mutable.Buffer[Int]()
    while(h > 0)  {
      h = 3 * h + 1
      buf += h
    }

    val sorter = new ShellSortArraySequence[T](drawer = (a: Array[T]) => (), seq = buf.toSeq)
    sorter.sort(a)

    !sorter.isExchanged
  }

  def exch[T](a: Array[T], i: Int, j: Int): Unit = {
    val t = a(i)
    a(i) = a(j)
    a(j) = t
  }
}

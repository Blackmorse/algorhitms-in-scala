package two.one

trait SortAlgorhitm[T] {
  implicit protected val toOrdered: T => Ordered[T]

  def sort(a: Array[T]): Unit

  protected def less(a: T, b: T): Boolean = a.compareTo(b) < 0

  protected def exch(a: Array[T], i: Int, j: Int): Unit = {
    val t = a(i)
    a(i) = a(j)
    a(j) = t
  }

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


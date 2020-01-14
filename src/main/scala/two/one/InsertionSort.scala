package two.one

class InsertionSort[T](override implicit protected val toOrdered: T => Ordered[T]) extends
  SortAlgorhitm[T]  {

  override def sort(a: Array[T]): Unit = {
    val n = a.length
    for (i <- 1 until n) {
      var j = i
      while(j > 0 && less(a(j), a(j-1))) { SortAlgorhitm.exch(a, j, j-1); j-=1}
    }
  }
}

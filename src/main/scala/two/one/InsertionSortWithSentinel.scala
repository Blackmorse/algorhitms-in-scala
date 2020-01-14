package two.one

class InsertionSortWithSentinel[T](override implicit protected val toOrdered: T => Ordered[T])
  extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var minIndex = 0
    var minValue = a(0)
    for (i <- 1 until n) {
      if (a(i) < minValue) {
        minValue = a(i)
        minIndex = i
      }
    }
    SortAlgorhitm.exch(a, 0, minIndex)

    for (i <- 1 until n) {
      var j = i
      while(less(a(j), a(j-1))) { SortAlgorhitm.exch(a, j, j-1); j-=1}
    }
  }
}

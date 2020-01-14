package two.one

class InsertionSortWithSentinelWithoutExchanges[T](override implicit protected val toOrdered: T => Ordered[T])
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
      val el = a(i)
      while(less(el, a(j - 1))) j -= 1

      for (t <- j.until(i).reverse ) {
        a(t + 1) = a(t)
      }
      a(j) = el
    }
  }
}

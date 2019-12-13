package two.one

class InsertionSortWithoutExchanged[T](override implicit protected val toOrdered: T => Ordered[T])
  extends SortAlgorhitm [T] {
  override def sort(a: Array[T]): Unit = {
    val n = a.length
    for(i <- 1 until n) {
      var j = i
      val el = a(i)
      while(j > 0 && less(el, a(j - 1))) j -= 1

      for (t <- j.until(i).reverse ) {
        a(t + 1) = a(t)
      }
      a(j) = el
    }
  }
}

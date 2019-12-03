package two.one

class InsertionSortWithSentinel[T](override val drawer: ADrawer[T] = (a: Array[T]) => ())(override implicit protected val toOrdered: T => Ordered[T])
  extends SortAlgorhitm[T] with Drawable[T] {
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
    exch(a, 0, minIndex)

    for (i <- 1 until n) {
      var j = i
      drawer.draw(a)
      while(less(a(j), a(j-1))) { exch(a, j, j-1); j-=1}
    }
  }
}

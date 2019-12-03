package two.one

class SelectionSort[T](override val drawer: ADrawer[T] = (a: Array[T]) => ())(override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] with Drawable[T] {
  override def sort(a: Array[T]): Unit = {
    val n = a.length
    for(i <- a.indices) {
      var min = i
      drawer.draw(a)
      for (j <- i + 1 until n) {
        if(less(a(j), a(min))) min = j
      }
      exch(a, i, min)
    }
  }


}

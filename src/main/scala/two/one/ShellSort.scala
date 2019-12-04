package two.one

class ShellSort[T](implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T]{

  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var h = 1
    while(h < n / 3) h = 3 * h + 1
    while( h >= 1) {

      for (i <- h until n) {
        var j = i
        while (j >= h && less(a(j), a(j -h ))) {
          exch(a, j, j-h)
          j -= h
        }

      }
      h /= 3
    }
  }
}

object ShellSort {
  def main(args: Array[String]): Unit = {
    val sorter = new ShellSort[Int]

    val a = Array(1,7,2,4,5,9,20,3)

    sorter.sort(a)

    println()
  }
}

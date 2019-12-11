package two.two

import edu.princeton.cs.algs4.StdRandom

import scala.reflect.ClassTag

class BottomUpMergeSort[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends MergeSort[T] {
  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var step = 1
    val copy = Array.fill[T](a.length)(null.asInstanceOf[T])
    while (step < n - 1) {

      var mergeBegin = 0
      while(mergeBegin + step - 1 < n - 1) {
        merge(a, mergeBegin, mergeBegin + step - 1, Math.min(mergeBegin + 2  * step - 1, n - 1), copy)
        mergeBegin += 2 * step
      }

      step *= 2
    }

  }
}
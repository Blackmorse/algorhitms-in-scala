package two.two.improved

import two.one.InsertionSortWithSentinelWithoutExchanges
import two.two.MergeSort

import scala.reflect.ClassTag

abstract class ImprovedMergeSortWithInsertion[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T])
  extends MergeSort[T] {

  private def insertionSort(array: Array[T], lo: Int, hi: Int): Unit = {
    var minIndex = lo
    var minValue = array(lo)
    for (i <- lo to hi) {
      if (array(i) < minValue) {
        minValue = array(i)
        minIndex = i
      }
    }
    exch(array, lo, minIndex)

    for (i <- lo + 1 to hi) {
      var j = i
      val el = array(i)
      while (less(el, array(j - 1))) j -= 1

      for (t <- j.until(i).reverse) {
        array(t + 1) = array(t)
      }
      array(j) = el
    }
  }

  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var step = Math.min(8, n - 1)
    val copy = Array.fill[T](a.length)(null.asInstanceOf[T])

    var mainArray = true

    while (step <= n - 1) {


      var mergeBegin = 0
      while (mergeBegin < n) {
        if (mainArray) {
          if (step > 8) {
            merge(a, mergeBegin, mergeBegin + step - 1, mergeBegin + 2 * step - 1, copy)
            mainArray = !mainArray
          } else {
            insertionSort(a, mergeBegin, Math.min(mergeBegin + 2 * step - 1, a.length - 1))

          }
        } else {
          if (step > 8) {
            merge(copy, mergeBegin, mergeBegin + step - 1, mergeBegin + 2 * step - 1, a)
          } else {
            insertionSort(copy, mergeBegin, Math.min(mergeBegin + 2 * step - 1, a.length - 1))
            mainArray = !mainArray
          }
        }

        mergeBegin += 2 * step
      }

      step *= 2
    }
    if (!mainArray) {
      for (i <- copy.indices) a(i) = copy(i)
    }

  }

}
package two.two

import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}

import scala.reflect.ClassTag

class CopyMergeSortWithAuxCreation[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {

  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int): Unit = {

    val value = (0 until (hi - lo + 1)).map(i => arr(i + lo))
    val aux = value.toArray

    var leftIndex = lo
    var rightIndex = mid + 1

    for (i <- lo to hi) {
      if (leftIndex > mid) {
        arr(i) = aux(rightIndex - lo); rightIndex += 1
      }
      else if (rightIndex > hi) {
        arr(i) = aux(leftIndex - lo); leftIndex += 1
      }
      else if (aux(rightIndex - lo) > aux(leftIndex - lo)) {
        arr(i) = aux(leftIndex - lo); leftIndex += 1
      }
      else {
        arr(i) = aux(rightIndex - lo); rightIndex += 1
      }
    }
  }

  override def sort(a: Array[T]): Unit = {
    val n = a.length
    var step = 1
    while (step <= n - 1) {

      var mergeBegin = 0
      while (mergeBegin + step - 1 < n - 1) {
        merge(a, mergeBegin, mergeBegin + step - 1, Math.min(mergeBegin + 2 * step - 1, n - 1))
        mergeBegin += 2 * step
      }

      step *= 2
    }
  }
}


object CopyMergeSortWithAuxCreation {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(attempts = 15, arrayGenerator = UniformArrayGenerator, draw = false,  algorhitms = Seq(
      new CopyMergeSortWithAuxCreation[Double](),
      new BottomUpMergeSort[Double]() with CopyMerger[Double]
    ))
  }
}

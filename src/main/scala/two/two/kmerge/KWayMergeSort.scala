package two.two.kmerge

import edu.princeton.cs.algs4.StdRandom
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.two.{BottomUpMergeSort, CopyMerger}

import scala.reflect.ClassTag

class KWayMergeSort[T: ClassTag](val k: Int)(override implicit protected val toOrdered: T => scala.Ordered[T]) extends SortAlgorhitm[T] {
  private val merger = new KCopyMerger[T]


  override def sort(a: Array[T]): Unit = {
    val copy = Array.fill(a.length)(null.asInstanceOf[T])
    var step = 1

    while (step < a.length) {

      var startIndex = 0

      while (startIndex < a.length) {
        merger.merge(startIndex, k, step, a, copy)
        startIndex += k * step
      }
      step *= k
    }
  }
}

object KWayMergeSort {

  def main(args: Array[String]): Unit = {
    DoublingTest.test(arrayGenerator = UniformArrayGenerator,
      draw = true,
      attempts = 15,
      algorhitms = Seq(

//        new KWayMergeSort[Double](4),
//        new KWayMergeSort[Double](5),
        new KWayMergeSort[Double](2),
        new KWayMergeSort[Double](3),
        new KWayMergeSort[Double](4),
        new KWayMergeSort[Double](5),
        new KWayMergeSort[Double](6),
        new KWayMergeSort[Double](7),
        new KWayMergeSort[Double](8),
    )
    )
  }
}

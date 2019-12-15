package two.two

import edu.princeton.cs.algs4.StdRandom
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

abstract class NaturalMergeSort[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T])
  extends MergeSort[T]  {

  override def sort(a: Array[T]): Unit = {

    val copy = Array.fill(a.length)(null.asInstanceOf[T])


    var lo = 0
    var mid = 0
    var i = 0

    while (!(lo ==0 && mid >= a.length - 1)) {
      i = 0
      while (i < a.length) {
        lo = i
        mid = nextIndex(a, i)
        i = mid
        if (mid < a.length - 1) {
          val hi = nextIndex(a, mid + 1)
          i = hi
          merge(a, lo, mid, hi, copy)
        }
        i += 1

      }
    }

  }

  private def nextIndex(a: Array[T], lo: Int): Int = {
    var i = lo
    while(i + 1 < a.length && a(i + 1) >= a(i)) i += 1
    i
  }
}

object NaturalMergeSort {
  def main(args: Array[String]): Unit = {
      DoublingTest.test(n = 1000, attempts = 15, arrayGenerator = UniformArrayGenerator,
        algorhitms = Seq(
          new NaturalMergeSort[Double]() with CopyMerger[Double],
          new NaturalMergeSort[Double]() with FasterCopyMerger[Double],
          new BottomUpMergeSort[Double]() with CopyMerger[Double],
          new ImprovedMergeSortWithInsertion[Double]() with ImprovedMergerWithComparsion[Double]
        ))

  }
}

package scala.two.three

import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, GaussianArrayGenerator, IntSequenceArrayGenerator, PoissonArrayGenerator, SortedArrayGenerator, UniformArrayGenerator, ZeroOneArrayGenerator}
import two.three.{CutoffQuickSort, QuickSort}

import scala.reflect.ClassTag

class QuickSortWithoutShuffling[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
//    Helper.shuffle(a)
    doSort(0, a.length -1 , a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if(hi <= lo) return
    val j = partition(lo, hi, a)
    doSort(lo, j - 1, a)
    doSort(j + 1, hi, a)
  }

  private def partition(lo: Int, hi: Int, a: Array[T]): Int =  {
    val v = a(lo)
    var left = lo
    var right = hi + 1
    var break = false

    while(!break) {
      break = false
      while(!break && {left += 1; a(left) < v}) if (left >= hi) break = true
      while({right -=1 ;a(right) > v}) if (right <= left) break = true
      if(left >= right) break = true
      if(!break) SortAlgorhitm.exch(a, left, right)
    }
    SortAlgorhitm.exch(a, lo, right)
    right
  }
}

object QuickSortWithoutShuffling {
  def main(args: Array[String]): Unit = {


    DoublingTest.test(draw = true, arrayGenerator = SortedArrayGenerator, n = 10000, t=4, attempts = 12, multiplier = 2,
      algorhitms = Seq(
        new QuickSort[Double](),
        new QuickSortWithoutShuffling[Double]()
      )
    )
  }
}

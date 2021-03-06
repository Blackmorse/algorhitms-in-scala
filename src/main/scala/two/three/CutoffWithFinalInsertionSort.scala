package scala.two.three

import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.three.CutoffQuickSort

import scala.reflect.ClassTag

  class CutoffWithFinalInsertionSort[T: ClassTag](cutoff: Int)(override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
    override def sort(a: Array[T]): Unit = {
      Helper.shuffle(a)
      doSort(0, a.length -1 , a)
      Helper.insertionSortSlice(a, 0, a.length - 1)
    }

    private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
      if(hi <= lo) return
      if (hi - lo < cutoff) {

        return
      }
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

object CutoffWithFinalInsertionSort {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = true, arrayGenerator = UniformArrayGenerator, n = 10000, t=10, attempts = 10,
      algorhitms = Seq(
        new CutoffQuickSort[Double](10),
        new CutoffWithFinalInsertionSort[Double](10)
      )
    )
  }
}

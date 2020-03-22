package scala.two.three

import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.UniformArrayGenerator

import scala.collection.mutable
import scala.common.Histogram
import scala.reflect.ClassTag

class CutoffQuickSortWithSizeCount[T: ClassTag](cutoff: Int)(override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  var cutoffs = mutable.ArrayBuffer[Int]()

  override def sort(a: Array[T]): Unit = {
    Helper.shuffle(a)
    doSort(0, a.length -1 , a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if(hi <= lo) return
    if (hi - lo < cutoff) {
      cutoffs += (hi - lo)
      Helper.insertionSortSlice(a, lo, hi)
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

object CutoffQuickSortWithSizeCount {
  def main(args: Array[String]): Unit = {
    val gen = UniformArrayGenerator



    val alg = new CutoffQuickSortWithSizeCount[Double](50)

    for (i <- 1 to 110) {
      val ar = gen.generate(100000)

      alg.sort(ar)
    }

    println(alg.cutoffs)

    Histogram.draw(alg.cutoffs.toSeq)
  }
}

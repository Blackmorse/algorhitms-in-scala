package two.three

import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

class QuickSort3Median [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    Helper.shuffle(a)
    doSort(0, a.length -1 , a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if(hi <= lo) return
    val j = partition(lo, hi, a)
    doSort(lo, j - 1, a)
    doSort(j + 1, hi, a)
  }

  private def partition(lo: Int, hi: Int, a: Array[T]): Int =  {
    val median = (hi - lo) / 2 + 1

    val s = Seq(lo, median, hi).view.map(l => (l, a(l))).sortBy(_._2).toSeq(2)
    SortAlgorhitm.exch(a, s._1, lo)

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

object QuickSort3Median {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = false, arrayGenerator = UniformArrayGenerator, n = 200000, t=3,
      algorhitms = Seq(
        new QuickSort3Median[Double](),
        new QuickSort[Double]()
      )
    )
  }
}
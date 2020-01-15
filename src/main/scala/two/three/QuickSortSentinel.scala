package two.three

import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

class QuickSortSentinel [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    Helper.shuffle(a)
    var largestIndex = 0
    var largest = a(0)

    for (i <- a.indices) {
      if (a(i) > largest) {
        largestIndex = i
        largest = a(i)
      }
    }

    SortAlgorhitm.exch(a, a.length - 1, largestIndex)
    doSort(0, a.length - 1 , a)
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
      while(!break && {left += 1; a(left) < v}) {}
      while({right -=1 ;a(right) > v}) {}
      if(left >= right) break = true
      if(!break) SortAlgorhitm.exch(a, left, right)
    }
    SortAlgorhitm.exch(a, lo, right)
    right
  }
}

object QuickSortSentinel {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = false, arrayGenerator = UniformArrayGenerator, n = 200000, t=3,
      algorhitms = Seq(
        new QuickSort[Double](),
        new QuickSortSentinel[Double]()
      )
    )
  }
}
package two.three

import edu.princeton.cs.algs4.StdRandom
import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}

import scala.reflect.ClassTag

class SystemSort  [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {

  override def sort(a: Array[T]): Unit = {
    Helper.shuffle(a)

    val medians = LazyList.continually(StdRandom.uniform(a.length)).take(9).sliding(3).toList.map(_.toList)

    val median = medians.map(list => list.sorted.tail.head).sorted.tail.head

    val t = a(0)
    a(0) = a(median)
    a(median) = t

    doSort(0, a.length - 1, a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if( hi <= lo) return

    if (hi - lo < 8) {
      Helper.insertionSortSlice(a, lo, hi)
      return
    }

    val v = a(lo)
    var i = lo
    var j = hi + 1
    var lt = i + 1
    var gt = hi

    var break  = false
    while(! break) {

      while(! break && {i += 1;  i<= hi && a(i) <= v}) {

        if (!break && a(i) == v) {
          SortAlgorhitm.exch( a, lt, i)
          lt += 1
        }
        if (i >= j) break = true
      }
      while({j -=1; j >= i && a(j) >= v}) {
        if(a(j) ==v ) {
          SortAlgorhitm.exch(a, gt, j)
          gt -= 1
        }
        if (j <= i) break = true
      }
      if (j <= i) break = true
      if(! break) SortAlgorhitm.exch(a, i, j)
    }
    (0 until (lt - lo)).foreach(t => SortAlgorhitm.exch(a, lo + t, j - t))
    (0 until (hi - gt)).foreach(t => SortAlgorhitm.exch(a, hi - t, i + t))

    doSort(lo, lo + j - lt, a)
    doSort(i + (hi - gt), hi, a)
  }
}

object SystemSort {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = true, arrayGenerator = UniformArrayGenerator, n = 200000, t=3,
      algorhitms = Seq(
        new QuickSortFast3WayPartitioning[Double](),
        new QuickSortWithEqualImprovement[Double](),
        new SystemSort[Double]()
      )
    )
  }
}

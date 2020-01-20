package two.three

import edu.princeton.cs.algs4.StdRandom
import help.Helper
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}
import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

class QuickSortFast3WayPartitioning  [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
        Helper.shuffle(a)
    doSort(0, a.length - 1, a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if( hi <= lo) return

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

object QuickSortFast3WayPartitioning {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = false, arrayGenerator = UniformArrayGenerator, n = 200000, t=3,
      algorhitms = Seq(
        new QuickSortFast3WayPartitioning[Double](),
        new QuickSortWithEqualImprovement[Double]()
      )
    )
  }
}
package two.three

import help.Helper
import two.one.tools.{DoublingTest, PartZeroArrayGenerator, UniformArrayGenerator}
import two.one.{InsertionSortWithSentinelWithoutExchanges, SortAlgorhitm}

import scala.reflect.ClassTag

class QuickSortWithEqualInsertionImprovement [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  val insertionSorter = new InsertionSortWithSentinelWithoutExchanges[T]()

  override def sort(a: Array[T]): Unit = {
    Helper.shuffle(a)
    doSort(0, a.length -1 , a)
  }

  private def doSort(lo: Int, hi: Int, a: Array[T]): Unit = {
    if (hi < lo) return
    if (hi - lo > 3) {
      val v = a(lo)
      var i = lo + 1
      var lt = lo
      var gt = hi

      while (i <= gt) {
        if (a(i) < v) {
          SortAlgorhitm.exch(a, lt, i)
          lt += 1
          i += 1
        } else if (a(i) > v) {
          SortAlgorhitm.exch(a, i, gt)
          gt -= 1
        } else {
          i += 1
        }
      }
      doSort(lo, lt - 1, a)
      doSort(gt + 1, hi, a)
    } else {
      Helper.insertionSortSlice(a, lo, hi)
    }
  }
}

object QuickSortWithEqualInsertionImprovement {

  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = false, arrayGenerator = PartZeroArrayGenerator(0.5d), n = 100000, t=3,
      algorhitms = Seq(
        new QuickSortWithEqualInsertionImprovement[Double](),
        new QuickSortWithEqualImprovement[Double](),
        new QuickSort[Double]()
      )
    )

  }
}

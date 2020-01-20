package two.three

import one.three.Stack
import two.one.SortAlgorhitm
import two.one.tools.{DoublingTest, UniformArrayGenerator}

import scala.reflect.ClassTag

class NonRecursiveQuickSort [T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {

    val stack = new Stack[(Int, Int)]
    stack.push((0, a.length - 1))

    while (!stack.isEmpty) {
      val (lo, hi) = stack.pop
      if (lo < hi) {
        val j = partition(lo, hi, a)
        if (hi - (j + 1) > (j - 1) - lo) {
          stack.push((j + 1, hi))
          stack.push(lo, j - 1)
        } else {
          stack.push(lo, j - 1)
          stack.push(j + 1, hi)
        }
      }
    }
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

object NonRecursiveQuickSort {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(draw = false, arrayGenerator = UniformArrayGenerator, n = 200000, t=3,
      algorhitms = Seq(
        new NonRecursiveQuickSort[Double](),
        new QuickSort[Double]()
      )
    )
  }
}

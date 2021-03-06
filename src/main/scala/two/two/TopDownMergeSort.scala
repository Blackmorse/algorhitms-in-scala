package two.two

import two.one.tools.{DoublingTest, UniformArrayGenerator}

import scala.reflect.ClassTag

abstract class TopDownMergeSort[T: ClassTag](override implicit protected val toOrdered: T => Ordered[T]) extends MergeSort[T]  {
  override def sort(a: Array[T]): Unit = {
    val copy = Array.fill[T](a.length)(null.asInstanceOf[T])
    sort(0, a.length - 1, a, copy)
  }

  private def sort(lo: Int, hi: Int, a: Array[T], copy: Array[T]): Unit = {
    if (hi - lo < 1) return
    val mid = lo + (hi - lo) / 2
    sort(lo, mid, a, copy)
    sort(mid + 1, hi, a, copy)
    merge(a, lo, mid, hi, copy)
  }
}

object TopDownMergeSort {
  def main(args: Array[String]): Unit = {
    DoublingTest.test(arrayGenerator = UniformArrayGenerator, attempts = 15, algorhitms = Seq(
      new TopDownMergeSort[Double]() with CopyMerger[Double],
      new BottomUpMergeSort[Double]() with CopyMerger[Double]
    ))
  }
}
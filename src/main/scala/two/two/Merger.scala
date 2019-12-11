package two.two

trait Merger[T] {
  this: MergeSort[T] =>

  implicit protected val toOrdered: T => Ordered[T]
  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit
}

package one.three.generalizedqueue

import scala.reflect.ClassTag

class ArrayGeneralizedQueue[T: ClassTag](capacity: Int = 1) extends GeneralizedQueue[T] {
  var arr: Array[T] = Array.fill(capacity)(null.asInstanceOf[T])
  private var n = 0



  override def isEmpty: Boolean = n == 0

  override def insert(t: T): Unit = {
    if (n >= arr.length) extendArray()
    arr(n) = t
    n += 1
  }

  private def extendArray(): Unit = {
    val newArr = Array.fill(arr.length * 2 + 1)(null.asInstanceOf[T])
    arr.zipWithIndex.foreach{case(el, n) => newArr(n) = el}
    arr = newArr
  }

  override def size: Int = n

  override def delete(k: Int): T = {
    n -= 1
    val r = arr(k)
    val leftArr = arr.take(k)
    val rightArr = arr.view.drop(k + 1)
    arr = leftArr ++ rightArr
    r
  }

  override def iterator: Iterator[T] = arr.take(n).iterator
}

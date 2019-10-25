package one.three.deque

import scala.reflect.ClassTag

class ResizingArrayDeque[T: ClassTag] extends Deque[T] {
  private var array: Array[T] = Array.fill(6)(null.asInstanceOf[T])
  private var left = 2
  private var right = 3


  override def pushLeft(value: T): Unit = {
    if (left < 0) increaseLeft()
    array(left) = value
    left -= 1
  }

  private def increaseLeft() = {
    val interval = array.length / 2
    val newSize = array.length + interval

    val newArray: Array[T] = Array.fill(newSize)(null.asInstanceOf[T])
    array.zipWithIndex.foreach{case(e, n) => newArray(n + interval) = e}
    array = newArray
    left +=interval
    right += interval
  }

  override def pushRight(value: T): Unit = {
    if (right >= array.length) increaseRight()
    array(right) = value
    right += 1
  }

  private def increaseRight() = {
    val interval = array.length / 2
    val newSize = array.length + interval

    val newArray: Array[T] = Array.fill(newSize)(null.asInstanceOf[T])
    array.zipWithIndex.foreach{case(e, n) => newArray(n) = e}
    array = newArray
  }

  override def popLeft(): T = {
    if (left + 1 >= right) throw new IllegalArgumentException("empty stack")
    if (left > array.length / 4 && array.length > 6) decreaseLeft()
    left += 1
    array(left)
  }

  private def decreaseLeft() = {
    val interval = left / 2
    left -= interval
    right -= interval
    array = array.drop(interval)
  }

  override def popRight(): T = {
    if (right - 1 <= left) throw new IllegalArgumentException("empty stack")
    if (array.length - right > array.length / 4 && array.length > 6 ) decreaseRight()
    right -= 1
    array(right)
  }

  private def decreaseRight(): Unit = {
    val interval = (array.length - right) / 2
    array = array.dropRight(interval)
  }

  override def iterator: Iterator[T] = array.drop(left + 1).dropRight(array.length - right).iterator
}

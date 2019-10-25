package one.three.deque

import one.three.DoubleList

class LinkedListDeque[T] extends Deque[T] {
  private val list = new DoubleList[T]

  override def isEmpty: Boolean = list.isEmpty

  override def pushLeft(value: T): Unit = list.insertBeginning(value)

  override def pushRight(value: T): Unit = list.insertEnd(value)

  override def popLeft(): T = list.removeFromBeginning()

  override def popRight(): T = list.removeFromEnd()

  override def iterator: Iterator[T] = list.iterator
}

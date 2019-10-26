package one.three.generalizedqueue

import one.three.LinkedList

class LinkedGeneralizedQueue[T] extends GeneralizedQueue[T] {
  private val list = new LinkedList[T]

  override def insert(t: T): Unit = list.add(t)

  override def delete(k: Int): T = list.delete(k)

  override def iterator: Iterator[T] = list.iterator
}

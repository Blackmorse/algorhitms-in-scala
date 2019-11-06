package one.four

import one.three.Queue

class StackWithQueue[T] {
  private val queue = new Queue[T]

  def push(t: T): Unit = queue.enqueue(t)

  def pop(): T = {
    1 until queue.size foreach (_ => queue.enqueue(queue.dequeue()))
    queue.dequeue()
  }

  def size: Int = queue.size

  def isEmpty = queue.isEmpty
}

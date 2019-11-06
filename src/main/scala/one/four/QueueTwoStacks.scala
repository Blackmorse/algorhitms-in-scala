package one.four

import one.three.Stack

class QueueTwoStacks[T] {
  private val stack1 = new Stack[T]()
  private val stack2 = new Stack[T]()

  def enqueue(t: T) = stack1.push(t)

  def dequeue(): T = {
    if (stack2.isEmpty) {
      while (!stack1.isEmpty) {
        stack2.push(stack1.pop)
      }
    }
    stack2.pop
  }

  def isEmpty: Boolean = stack1.isEmpty && stack2.isEmpty
}

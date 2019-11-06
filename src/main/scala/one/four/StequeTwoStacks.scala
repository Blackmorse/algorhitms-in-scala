package one.four

import one.three.Stack

class StequeTwoStacks[T] {

  private val stack1 = new Stack[T]
  private val stack2 = new Stack[T]

  def push(t: T): Unit = stack1.push(t)

  def pop(): T = {
    if (stack1.isEmpty) {
      while(!stack2.isEmpty) {
        stack1.push(stack2.pop)
      }
    }
    stack1.pop
  }

  def enqueue(t: T): Unit = stack2.push(t)

  def isEmpty: Boolean = stack1.isEmpty && stack2.isEmpty
}

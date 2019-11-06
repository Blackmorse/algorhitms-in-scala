package one.four

import one.three.{Stack, Steque}
import one.three.deque.Deque

class StackStequeDeque[T] extends Deque[T]{
  private val steque = new Steque[T]

  private val stack = new Stack[T]

  override def pushLeft(value: T): Unit = steque.push(value)

  override def pushRight(value: T): Unit = stack.push(value)

  override def popLeft(): T = {
    if(steque.isEmpty && stack.isEmpty) throw new IllegalArgumentException("No elements")
    if(!steque.isEmpty) {
      steque.pop()
    } else {
      val n = if (stack.size == 1) 1 else stack.size / 2
      val N = stack.size
      while (!stack.isEmpty) steque.push(stack.pop)
      1 to n foreach (_ => steque.enqueue(steque.pop()))
      1 to (N - n) foreach (_ => stack.push(steque.pop()))
      steque.pop()
    }
  }

  override def popRight(): T = {
    if(steque.isEmpty && stack.isEmpty) throw new IllegalArgumentException("No elements")
    if (!stack.isEmpty) {
      stack.pop
    }else {
      val n = steque.size / 2
      1 to n foreach (_ => steque.enqueue(steque.pop()))
      1 to (steque.size - n) foreach (_ => stack.push(steque.pop))
      stack.pop
    }
  }

  override def iterator: Iterator[T] = {
    val tmpStack = new Stack[T]
    val copyStack = new Stack(stack)
    while (!copyStack.isEmpty) tmpStack.push(copyStack.pop)
    steque.iterator ++ tmpStack.iterator
  }
}

object StackStequeDeque {
  def main(args: Array[String]): Unit = {
    val deque = new StackStequeDeque[Int]

    deque.pushRight(1)
    deque.pushRight(2)
    deque.pushRight(3)

    val a = deque.popLeft()
    val b = deque.popLeft()
    val c = deque.popLeft()
  }
}

package one.four

import one.three.Stack
import one.three.deque.Deque

class ThreeStacksDeque[T] extends Deque[T] {
  private val leftStack = new Stack[T]
  private val rightStack = new Stack[T]
  private val thirdStack = new Stack[T]

  override def pushLeft(value: T): Unit = leftStack.push(value)

  override def pushRight(value: T): Unit = rightStack.push(value)

  override def popLeft(): T = {
    if(leftStack.isEmpty && rightStack.isEmpty) throw new IllegalArgumentException("No elements")
    if (leftStack.isEmpty) {
      val n = rightStack.size / 2
      1 to n foreach (_ => thirdStack.push(rightStack.pop))
      while (!rightStack.isEmpty) leftStack.push(rightStack.pop)
      while (!thirdStack.isEmpty) rightStack.push(thirdStack.pop)
    }
    leftStack.pop
  }

  override def popRight(): T = {
    if(leftStack.isEmpty && rightStack.isEmpty) throw new IllegalArgumentException("No elements")
    if (rightStack.isEmpty) {
      val n = leftStack.size
      1 to n foreach (_ => thirdStack.push(leftStack.pop))
      while(!leftStack.isEmpty) rightStack.push(leftStack.pop)
      while(!thirdStack.isEmpty) leftStack.push(thirdStack.pop)
    }
    rightStack.pop
  }

  override def iterator: Iterator[T] = {
    val tmpStack = new Stack[T]
    val copyStack = new Stack(rightStack)
    while (!copyStack.isEmpty) tmpStack.push(copyStack.pop)
    leftStack.iterator ++ tmpStack.iterator
  }
}

package one.three.deque

import one.three.Stack

class TwoStacksDeque[T] extends Deque[T] {
  private val leftStack = new Stack[T]()
  private val rightStack = new Stack[T]()

  override def pushLeft(value: T): Unit = leftStack.push(value)

  override def pushRight(value: T): Unit = rightStack.push(value)

  override def popLeft(): T = if(!leftStack.isEmpty) {
    leftStack.pop
  } else {
    val tmpStack = new Stack[T]
    while (!rightStack.isEmpty) {
      tmpStack.push(rightStack.pop)
    }
    val r = tmpStack.pop
    while(!tmpStack.isEmpty) {
      rightStack.push(tmpStack.pop)
    }
    r
  }

  override def popRight(): T = if(!rightStack.isEmpty) {
    rightStack.pop
  } else {
    val tmpStack = new Stack[T]
    while (!leftStack.isEmpty) {
      tmpStack.push(leftStack.pop)
    }
    val r = tmpStack.pop
    while(!tmpStack.isEmpty) {
      leftStack.push(tmpStack.pop)
    }
    r
  }

  //Iterator for testing puposes
  override def iterator: Iterator[T] = {
    val tmpStack = new Stack[T]
    val copyStack = new Stack(rightStack)
    while (!copyStack.isEmpty) tmpStack.push(copyStack.pop)
    leftStack.iterator ++ tmpStack.iterator
  }
}

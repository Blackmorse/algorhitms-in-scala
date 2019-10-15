package one.three

object CopyStack {
  def copyStack[T](stack: Stack[T]): Stack[T] ={
    val tempStack = new Stack[T]
    for (t <- stack) {
      tempStack.push(t)
    }

    val resultStack = new Stack[T]
    for (t <- tempStack) {
      resultStack.push(t)
    }
    resultStack
  }
}

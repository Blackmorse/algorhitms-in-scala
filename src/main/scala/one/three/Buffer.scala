package one.three

class Buffer {
  private val leftStack = new Stack[Char]()
  private val rightStack = new Stack[Char]()

  def insert(c: Char): Unit = {
    leftStack.push(c)
  }

  def delete(): Char = leftStack.pop

  def left(k: Int): Unit = {
    1 to k foreach (_ => {rightStack.push(leftStack.pop)})
  }

  def right(k: Int): Unit = 1 to k foreach (_ => {leftStack.push(rightStack.pop)})

  def size: Int = leftStack.size + rightStack.size
}

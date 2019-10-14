package one.three

import scala.collection.mutable


class Stack[Item] extends Iterable[Item] {
  private class Node {
    var item: Item = _
    var next: Node = _
  }

  private var first: Node = _

  private var N = 0

  override def isEmpty: Boolean = first == null

  override def size: Int = N

  def push(item: Item): this.type = {
    val oldFirst = first
    first = new Node
    first.item = item
    first.next = oldFirst
    N += 1
    this
  }

  def pop: Item = {
    val item = first.item
    first = first.next
    N -= 1
    item
  }

  def peek(): Item = {
    if (first != null) first.item
    else null.asInstanceOf[Item]
  }

  override def iterator: Iterator[Item] = new Iterator[Item] {
    private var current = first

    override def hasNext: Boolean = current != null

    override def next(): Item = {
      val item = current.item
      current = current.next
      item
    }
  }
}

object Stack {
  def main(args: Array[String]): Unit = {
    val buffer = mutable.Buffer[Int]()

    println("a:")
    val stack = new Stack[Int]
    stack.push(0).push(1).push(2).push(3).push(4)
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    stack.push(5).push(6).push(7).push(8).push(9)
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop

    println(buffer.mkString(","))

    buffer.clear()
    println("c:")
    stack.push(0).push(1).push(2)
    buffer += stack.pop
    stack.push(3).push(4).push(5)
    buffer += stack.pop
    stack.push(6)
    buffer += stack.pop
    stack.push(7)
    buffer += stack.pop
    buffer += stack.pop
    stack.push(8)
    buffer += stack.pop
    stack.push(9)
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop

    println(buffer.mkString(","))

    buffer.clear()

    println("d:")

    stack.push(0).push(1).push(2).push(3).push(4)
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    stack.push(5)
    buffer += stack.pop
    stack.push(6)
    buffer += stack.pop
    stack.push(7)
    buffer += stack.pop
    stack.push(8)
    buffer += stack.pop
    stack.push(9)
    buffer += stack.pop

    println(buffer.mkString(","))

    buffer.clear()

    println("e:")
    stack.push(0)
    stack.push(1)
    buffer += stack.pop
    stack.push(2)
    buffer += stack.pop
    stack.push(3)
    buffer += stack.pop
    stack.push(4)
    buffer += stack.pop
    stack.push(5)
    buffer += stack.pop
    stack.push(6)
    buffer += stack.pop
    stack.push(7).push(8).push(9)
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop
    buffer += stack.pop

    println(buffer.mkString(","))

    buffer.clear()

    println("h:")
    stack.push(0).push(1).push(2)
    buffer += stack.pop
    buffer += stack.pop
    stack.push(3).push(4)
    buffer += stack.pop
    buffer += stack.pop
    stack.push(5).push(6)
    buffer += stack.pop
    buffer += stack.pop
    stack.push(7).push(8)
    buffer += stack.pop
    buffer += stack.pop
    stack.push(9)
    buffer += stack.pop
    buffer += stack.pop

    println(buffer.mkString(","))
  }
}



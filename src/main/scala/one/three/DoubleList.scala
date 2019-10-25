package one.three

case class DoubleNode[T](value: T, var previous: DoubleNode[T], var next: DoubleNode[T])

class DoubleList[T] extends  Iterable[T] {
  var first: DoubleNode[T] = null

  override def isEmpty: Boolean = first == null

  def insertBeginning(value: T) = {
    if (first == null) {
      first = new DoubleNode[T](value, null, null)
    } else {
      val node = new DoubleNode[T](value, null, first)
      first.previous = node
      first = node
    }
  }

  def insertEnd(value: T) = {
    if (first == null) {
      first = new DoubleNode[T](value, null, null)
    } else {
      val el = lastElement()
      val node = new DoubleNode[T](value, el, null)
      el.next = node
    }
  }

  def removeFromBeginning(): T = {
    val r = first.value
    if (first.next == null) {
      first = null
    } else {
      first = first.next
      first.previous = null
    }
    r
  }

  def removeFromEnd(): T = {
    val last = lastElement()
    if (last.previous == null) {
      val r = first.value
      first = null
      r
    } else {
      val r = last.value
      last.previous.next = null
      last.previous = null
      r
    }
  }


  private def lastElement(): DoubleNode[T] = {
    var current = first
    if (current != null) {
      while (current.next != null) current = current.next
    }
    current
  }

  override def iterator: Iterator[T] = new Iterator[T] {
    var current = first

    override def hasNext: Boolean = current != null

    override def next(): T = {
      val result = current
      current = current.next
      result.value
    }
  }

  def reverseIterator: Iterator[T] = new Iterator[T] {
    var current = lastElement()

    override def hasNext: Boolean = current != null

    override def next(): T = {
      val result = current
      current = current.previous
      result.value
    }
  }
}

object DoubleList {
  def insertBefore[T](node: DoubleNode[T], value: T) = {
    val newNode = new DoubleNode[T](value, null, null)
    if (node.previous == null) throw new Exception("this is first node")
    val previous = node.previous
    newNode.previous = previous
    newNode.next = node

    previous.next = newNode
    node.previous = newNode
  }

  def insertAfter[T](node: DoubleNode[T], value: T) = {
    val newNode = new DoubleNode[T](value, null, null)

    if(node.next == null) {
      node.next = newNode
      newNode.previous = node
    } else {
      val next = node.next
      newNode.next = next
      newNode.previous = node
      node.next = newNode
      next.previous = newNode
    }
  }

  def remove[T](node: DoubleNode[T]) = {
    if (node.previous == null) throw new Exception("this is first node")
    if (node.next == null) {
      node.previous.next = null
    } else {
      val next = node.next
      val previous = node.previous
      next.previous = previous
      previous.next = next
    }
  }
}

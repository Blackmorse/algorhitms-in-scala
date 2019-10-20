package one.three

sealed case class Node[T](var value: T, var next: Node[T])

class LinkedList[T] extends Iterable[T] {

  var first: Node[T] = null

  def add(value: T): Unit = {
    if (first == null) {
      first = new Node[T](value, null)
    } else {
      var el = first
      while (el.next != null) el = el.next
      el.next = Node(value, null)
    }
  }

  def removeLast(): Unit = {
    if(first == null) return
    var node: Node[T] = null
    var next: Node[T] = first
    while (next.next != null) {
      node = next
      next = next.next
    }

    node.next = null
  }

  def delete(n: Int) = {
    if (n == 0) first = first.next else {
      var prev: Node[T] = null
      var elem = first
      0 until n foreach (_ => {
        prev = elem; elem = elem.next
      })
      prev.next = elem.next
    }
  }


  def find(value: T): Boolean = {
    var el = first
    while (el != null) {
      if (el.value == value) return true
      el = el.next
    }
    false
  }

  override def iterator: Iterator[T] = new Iterator[T] {
    var current: Node[T] = first

    override def hasNext: Boolean = current != null

    override def next(): T = {
      val result = current
      current = current.next
      result.value
    }
  }
}

object LinkedList {
  def removeAfter[T](node: Node[T]) = {
    if (node.next != null) {
      node.next = node.next.next
    }
  }
}

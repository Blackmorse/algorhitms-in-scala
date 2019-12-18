package one.three

import scala.annotation.tailrec

case class Node[T](var value: T, var next: Node[T]) {
  override def toString: String = s"$value"
}

class LinkedList[T] extends Iterable[T] {

  var first: Node[T] = null
  var lastEl: Node[T] = null

  def add(value: T): Unit = {
    if (first == null) {
      first = new Node[T](value, null)
      lastEl = first
    } else {
      lastEl.next = Node(value, null)
      lastEl = lastEl.next
    }
  }

  def addFirst(value: T): Unit = {
    val newNode = Node(value, first)
    if(first == null) {
      lastEl = newNode
    }
    first = newNode
  }

  def removeLast(): T = {
    if(first == null) throw new Exception("empty List")
    var node: Node[T] = null
    var next: Node[T] = first
    while (next.next != null) {
      node = next
      next = next.next
    }
    val r = next.value
    if (node != null) {
      node.next = null
      lastEl = node
    } else {
      first = null
      lastEl = null
    }
    r
  }

  def delete(n: Int): T = {
    if (n == 0) {
      val r = first.value
      first = first.next
      r
    } else {
      var prev: Node[T] = null
      var elem = first
      0 until n foreach (_ => {
        prev = elem; elem = elem.next
      })
      val r = elem.value
      prev.next = elem.next
      r
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

  def remove(value: T) = {
    var prev: Node[T] = null
    var el = first
    while (el != null) {
      if(el.value == value) {
        if (el == first) {
          first = first.next
          el = first
        } else {
          LinkedList.removeAfter(prev)
          el = prev.next
        }
      } else {
        prev = el
        el = el.next
      }
    }
  }

  override def max[B >: T](implicit ord: Ordering[B]): T = {
    var max = first.next.value

    var el = first

    while (el != null) {
      if (ord.compare(el.value, max) > 0) {
        max = el.value
      }
      el = el.next
    }
    max
  }

  def maxRec[B >: T](implicit ord: Ordering[B]): T = {
    @tailrec
    def doMaxRec(node: Node[T], max: T): T = {
      if (node == null) max
      else {
        val m = if(ord.compare(node.value, max) > 0) node.value else max
        doMaxRec(node.next, m)
      }
    }
    if(first != null) doMaxRec(first, first.value)
    else null.asInstanceOf[T]
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

  def insertAfter[T](node: Node[T], toInsert: Node[T]) = {
    if (node != null && toInsert != null) {
      var current = node
      while(current.next != null) {
        current = current.next
      }
      current.next = toInsert
    }
  }

  def reverseIterative[T](list: LinkedList[T]): LinkedList[T] = {
    var previous: Node[T] = null
    var current = list.first
    while(current != null) {
      val next = current.next
      current.next = previous

      previous = current

      current = next
    }
    val first = previous

    val result = new LinkedList[T]
    result.first = first
    result
  }

  def reverseRecursive[T](list: LinkedList[T]): LinkedList[T] = {
    if (list.isEmpty) return new LinkedList[T]
    def doReverse(previous: Node[T], node: Node[T]): Node[T] = {
      val first = if (node.next == null) node else doReverse(node, node.next)
      node.next = previous
      first
    }

    val reverse = doReverse(null, list.first)
    val result = new LinkedList[T]
    result.first = reverse
    result
  }
}

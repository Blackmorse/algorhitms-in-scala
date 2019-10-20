package one.three

import scala.annotation.tailrec

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
}

package two.two

import edu.princeton.cs.algs4.StdRandom
import one.three.{LinkedList, Node}

class LinkedListNaturalMergeSort[T](implicit protected val toOrdered: T => Ordered[T]) {

  private def next(node: Node[T], list: LinkedList[T]) : Node[T] = {
    if (node == null) list.first
    else node.next
  }

  def sort(list: LinkedList[T]): Unit = {
    var lo: Node[T] = null
    var prev: Node[T] = null

    while (lo != list.first) {
      prev = null
      var cur = list.first

      while (cur != null) {
        lo = cur
        val (prevMid, mid, leftLength) = nextMaximum(prev, cur, list)
        cur = mid
        if (cur != null) {
          val (prevHi, hi, rightLength) = nextMaximum(prevMid, cur, list)
          cur = hi
          prev = merge(prev, hi, lo, mid, leftLength, rightLength, list)
        }
      }
    }
  }

  private def nextMaximum(previous: Node[T], lo: Node[T], list: LinkedList[T]): (Node[T], Node[T], Int) = {
    var prev = previous
    var cur = lo
    var i = 1
    while(cur.next != null && cur.value <= cur.next.value) {
      i += 1
      prev = next(prev, list)
      cur = cur.next
    }
    (next(prev, list), cur.next, i)
  }

  private def merge(previous: Node[T], next: Node[T], lo: Node[T], mid: Node[T], leftLength: Int, rightLength: Int, list: LinkedList[T]): Node[T] = {
    def changePrev(prev: Node[T], newNext: Node[T]): Unit = {
      if (prev == null) list.first = newNext
      else prev.next = newNext
    }

    var prev = previous

    var left = lo
    var right = mid

    for (i <- 0 until leftLength + rightLength) {
      if(left == mid) {
        changePrev(prev, right)
        prev = right
        right = right.next}
      else if(right == next) {
        changePrev(prev, left)
        prev = left
        left = left.next}
      else if(right.value > left.value) {
        changePrev(prev, left)
        prev = left
        left = left.next}
      else {
        changePrev(prev, right)
        prev = right
        right = right.next
      }
    }

    prev.next = next
    prev
  }
}

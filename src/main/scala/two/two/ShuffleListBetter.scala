package two.two

import edu.princeton.cs.algs4.StdRandom
import one.three.{LinkedList, Node}

object ShuffleListBetter {
  private def next[T](node: Node[T], list: LinkedList[T]): Node[T] = {
    if (node == null) list.first
    else node.next
  }

  def shuffle[T](list: LinkedList[T]) = {
    var step = 1
    var lo: Node[T] = null
    while (lo != list.first) {

      var cur: Node[T] = list.first

      var prev: Node[T] = null

      while (cur != null) {
        lo = cur
        val (preMid, mid, leftLength) = nextElement(prev, cur, step, list)
        cur = mid
        if (mid != null) {
          val (preHi, hi, rightLength) = nextElement(preMid, mid, step, list)
          cur = hi

          prev = merge(prev, hi, lo, mid, leftLength, rightLength, list)
        }
      }
      step *= 2
    }
  }

  def nextElement[T](prev: Node[T], lo: Node[T], step: Int, list: LinkedList[T]): (Node[T], Node[T], Int) = {
    var i = 0
    var prevCur = prev
    var cur = lo
    while (cur != null && i < step) {
      cur = cur.next
      prevCur = next(prevCur, list)
      i += 1
    }

    (prevCur, cur, i)
  }

  private def merge[T](previous: Node[T], next: Node[T], lo: Node[T], mid: Node[T], leftLength: Int, rightLength: Int, list: LinkedList[T]): Node[T] = {
    def changePrev(prev: Node[T], newNext: Node[T]): Unit = {
      if (prev == null) list.first = newNext
      else prev.next = newNext
    }

    var prev = previous

    var left = lo
    var right = mid

    for (i <- 0 until leftLength + rightLength) {
      if (right == next) {
        changePrev(prev, left)
        prev = left
        left = left.next
      } else if (left == mid) {
        changePrev(prev, right)
        prev = right
        right = right.next
      } else if (StdRandom.bernoulli()) {
        changePrev(prev, left)
        prev = left
        left = left.next
      } else {
        changePrev(prev, right)
        prev = right
        right = right.next
      }
    }

    prev.next = next
    prev
  }
}
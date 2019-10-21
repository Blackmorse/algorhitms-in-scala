package one.three

class CircularQueue[T] {
  var last: Node[T] = null

  def enqueue(value: T): Unit = {
    if (last == null) {
      last = new Node(value, null)
      last.next = last
    } else {
      val node = new Node(value, last.next)
      last.next = node
      last = node
    }
  }

  def dequeue(): T = {
    if(last.next == last) {
      val r = last.value
      last = null
      r
    } else {
      val r = last.next.value
      last.next = last.next.next
      r
    }
  }

  def isEmpty(): Boolean = last == null
}

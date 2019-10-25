package one.three

class CircularQueue[T] {
  private var lastEl: Node[T] = null

  def enqueue(value: T): Unit = {
    if (lastEl == null) {
      lastEl = new Node(value, null)
      lastEl.next = lastEl
    } else {
      val node = new Node(value, lastEl.next)
      lastEl.next = node
      lastEl = node
    }
  }

  def dequeue(): T = {
    if(lastEl.next == lastEl) {
      val r = lastEl.value
      lastEl = null
      r
    } else {
      val r = lastEl.next.value
      lastEl.next = lastEl.next.next
      r
    }
  }

  def definedSize: Int = {
    if(lastEl == null) {
      0
    } else if(lastEl.next == lastEl) {
      1
    } else {
      -1 //Not defined :)
    }
  }

  def isEmpty(): Boolean = lastEl == null

  def circularIterator(): RemovableIterator[T] = new RemovableIterator[T]{
    private var previous = lastEl
    private var current = if (lastEl == null) null else lastEl.next

    override def hasNext: Boolean = current != null

    override def next(): T = {
      previous = current
      current = current.next
      previous.value
    }

    override def remove(): T = {
      if (current.next == current) {
        val r = current.value
        current = null
        previous = null
        lastEl = null
        r
      } else {
        val r = current.value
        if(lastEl == current) {
          lastEl = previous
        }
        previous.next = current.next
        current = previous.next
        r
      }
    }
  }
}

trait RemovableIterator[T] extends Iterator[T] {
  def remove(): T
}

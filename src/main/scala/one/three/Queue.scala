package one.three

class Queue[Item] extends Iterable[Item] {
  private var first: Node = _ // link to least recently added node

  private var _last: Node = _ // link to most recently added node

  private var N = 0

  // number of items on the queue

  private class Node { // nested class to define nodes
    var item: Item = _
    var next: Node = _
  }

  override def isEmpty: Boolean = first == null

  override def size = N

  def enqueue(item: Item): this.type = { // Add item to the end of the list.
    val oldLast = _last
    _last = new Node
    _last.item = item
    _last.next = null
    if (isEmpty) first = _last
    else oldLast.next = _last
    N += 1
    this
  }

  def dequeue() = { // Remove item from the beginning of the list.
    val item = first.item
    first = first.next
    if (isEmpty) _last = null
    N -= 1
    item
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
package two.two

import one.three.Queue
import two.one.SortAlgorhitm

class QueueMergeSort[T](override implicit protected val toOrdered: T => Ordered[T]) extends SortAlgorhitm[T] {
  override def sort(a: Array[T]): Unit = {
    val queue = new Queue[Queue[T]]

    a.foreach(el => queue.enqueue(new Queue[T]().enqueue(el)))

    while(queue.size != 1) {
      val sorted = SortedQueueMerger.merge(queue.dequeue(), queue.dequeue())
      queue.enqueue(sorted)
    }

    val resQueue = queue.dequeue()
    for (i <- a.indices) {
      a(i) = resQueue.dequeue()
    }
  }
}

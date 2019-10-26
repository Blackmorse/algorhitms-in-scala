package one.three

import java.util.concurrent.atomic.AtomicInteger

import scala.reflect.ClassTag

class RingBuffer[T: ClassTag](capacity: Int) {
  private val array: Array[T] = Array.fill(capacity)(null.asInstanceOf[T])

  private var position = 0
  private val n = new AtomicInteger(0)

  def enqueue(t: T) =  {
    while(n.get() == capacity) {
      this.synchronized{wait()}
    }

    this.synchronized {
      array(position) = t
      n.getAndAdd(1)
      if (position < capacity - 1) position += 1
      else position = 0
      notifyAll()
    }
  }

  def dequeue(): T = {
    while(n.get() == 0) {
      this.synchronized{ wait()}
    }
    this.synchronized {

      val previousPosition = if (position == 0) capacity - 1 else position - 1

      val r = if (previousPosition - n.get() + 1 < 0) {
        val index = previousPosition - n.get() + 1 + capacity
        array(index)
      } else {
        array(previousPosition - n.get() + 1)
      }
      n.getAndAdd(-1)

      notifyAll()
      r
    }
  }

  def size = n.get()
}

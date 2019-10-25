package one.three

import edu.princeton.cs.algs4.StdRandom

import scala.reflect.ClassTag

class RandomQueue[T: ClassTag] extends Iterable[T] {
  private val arrayQueue = new ResizingArrayQueue[T](1)

  override def isEmpty: Boolean = arrayQueue.isEmpty

  def enqueue(t: T): Unit = arrayQueue.enqueue(t)

  def dequeue(): T = {
    val index = StdRandom.uniform(arrayQueue.size) + arrayQueue.firstIndex
    val t = arrayQueue.arr(index)
    arrayQueue.arr(index) = arrayQueue.arr(arrayQueue.firstIndex)
    arrayQueue.arr(arrayQueue.firstIndex) = t
    arrayQueue.dequeue()
  }

  def sample(): T = {
    val r = StdRandom.uniform(arrayQueue.size)
    arrayQueue.arr(arrayQueue.firstIndex + r)
  }

  override def iterator: Iterator[T] = {
    val shuffle = arrayQueue.iterator.toArray.map(_.asInstanceOf[Object])
    StdRandom.shuffle(shuffle)

    shuffle.map(_.asInstanceOf[T]).iterator
  }
}

package one.three

import edu.princeton.cs.algs4.StdRandom

import scala.reflect.ClassTag

class RandomBag[T: ClassTag] extends Iterable[T] {
  private val array = new ResizingArrayQueue[T](5)

  override def isEmpty: Boolean = array.isEmpty

  override def size: Int = array.size

  def add(t: T): Unit = array.enqueue(t)

  override def iterator: Iterator[T] = {
    val shuffle = array.iterator.map(_.asInstanceOf[Object]).toArray
    StdRandom.shuffle(shuffle)

    shuffle.map(_.asInstanceOf[T]).iterator
  }
}

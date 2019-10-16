package one.three

import edu.princeton.cs.algs4.Transaction

import scala.reflect.ClassTag

class ResizingArrayQueue[T: ClassTag](private var initialSize: Int) extends Iterable[T] {
  var arr: Array[T] = Array.fill(initialSize)(null.asInstanceOf[T])
  var lastIndex = 0
  var firstIndex = 0


  def enqueue(element: T): this.type = {
    if (lastIndex >= arr.length) {
      shrinkBeginning()
    }
    if (lastIndex >= arr.length) {
      extendArray()
    }

    arr(lastIndex) = element
    lastIndex += 1
    this
  }

  private def extendArray() = {
    val newArr: Array[T] = Array.fill(arr.length * 2)(null.asInstanceOf[T])
    arr.zipWithIndex.foreach { case (t, i) => newArr(i) = t }

    arr = newArr
  }

  private def shrink() {
    if (lastIndex < arr.length / 4) {
      val newArr: Array[T] = Array.fill(arr.length / 4)(null.asInstanceOf[T])
      arr.take(lastIndex).zipWithIndex.foreach { case (t, i) => newArr(i) = t }
      arr = newArr
    }
  }

  private def shrinkBeginning(): Unit = {
    if (firstIndex > 0 ) {
      val newArr: Array[T] = Array.fill(arr.size)(null.asInstanceOf[T])
      arr.drop(firstIndex).zipWithIndex.foreach { case (t, i) => newArr(i) = t }
      lastIndex = lastIndex - firstIndex
      firstIndex = 0
      arr = newArr
    }
  }

  def dequeue(): T = {
    if (firstIndex >= lastIndex) throw new IllegalArgumentException("No elements")

    if(lastIndex - firstIndex < arr.length / 4) {
      shrinkBeginning()
      shrink()
    }
    val r = arr(firstIndex)
    firstIndex += 1
    r
  }

  override def size: Int = lastIndex - firstIndex

  override def iterator: Iterator[T] = {
    shrinkBeginning()
    arr.take(lastIndex).iterator
  }
}

object ResizingArrayQueue {
  def main(args: Array[String]): Unit = {
    val queue = new ResizingArrayQueue[Int](20)
    queue.enqueue(1).enqueue(2).enqueue(3)
    assert(queue.dequeue() == 1)
    assert(queue.arr.length == 5)
    assert(queue.dequeue() == 2)
    assert(queue.dequeue() == 3)
  }
}

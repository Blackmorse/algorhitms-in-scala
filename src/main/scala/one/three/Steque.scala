package one.three

class Steque[T] extends Iterable[T]{
 private val list = new LinkedList[T]

 def push(value: T) = {
   list.addFirst(value)
  }

 def pop(): T = {
    list.delete(0)
 }

 def enqueue(value: T) = {
    list.add(value)
 }

  override def iterator: Iterator[T] = list.iterator
}

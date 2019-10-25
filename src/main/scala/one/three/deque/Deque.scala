package one.three.deque

trait Deque[T] extends Iterable[T]{
  def isEmpty: Boolean
  def size: Int
  def pushLeft(value: T): Unit
  def pushRight(value: T): Unit
  def popLeft(): T
  def popRight(): T
}

package one.three.generalizedqueue

trait GeneralizedQueue[T] extends Iterable[T] {
  def isEmpty: Boolean

  def insert(t: T)

  def delete(k: Int): T
}

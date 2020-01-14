package two.three

object TwoDistinctSort {
  def sort[T](a: Array[T])(implicit toOrdered: T => Ordered[T]) = {
    val grouping = a.groupBy(identity).toSeq.map{case (e, els) => (e, els.length)}
    val first = grouping.head
    val second = grouping(1)
    if(first._1 > second._1) {
      (0 until second._2).foreach(i => a(i) = second._1)
      (second._2 until a.length).foreach(i => a(i) = first._1)
    } else {
      (0 until first._2).foreach(i => a(i) = first._1)
      (first._2 until a.length).foreach(i => a(i) = second._1)
    }
  }
}

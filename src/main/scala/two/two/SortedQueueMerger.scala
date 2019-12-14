package two.two

import one.three.Queue

object SortedQueueMerger {
  def merge[T](q1: Queue[T], q2: Queue[T])(implicit  ord: T => Ordered[T]): Queue[T] = {
    val res = new Queue[T]()

    val it1 = q1.iterator
    val it2 = q2.iterator

    var lastElement = true

    var el1: Option[T] = None //= if(it1.hasNext) Some(it1.next()) else None

    var el2 = if(it2.hasNext) Some(it2.next()) else None

    for (i <- 0 until q1.size + q2.size) {
      if (lastElement) {
        el1 = if(it1.hasNext) Some(it1.next()) else None
      } else {
        el2 = if(it2.hasNext) Some(it2.next()) else None
      }


      if (el1.isEmpty) {res.enqueue(el2.get); lastElement = false}
      else if (el2.isEmpty) {res.enqueue(el1.get); lastElement = true}
      else if (el1.get > el2.get) {res.enqueue(el2.get); lastElement = false}
      else {res.enqueue(el1.get); lastElement = true}
    }
    res
  }

  def main(args: Array[String]): Unit = {
    val q1 = new Queue[Int].enqueue(1).enqueue(5).enqueue(7)
    val q2 = new Queue[Int].enqueue(2).enqueue(3).enqueue(6)

    val res = SortedQueueMerger.merge(q1, q2)


    res.foreach(println)
  }
}



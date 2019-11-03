package one.four

import scala.collection.mutable

object SortedArraysIntersection {
  def intersection(ar1: Array[Int], ar2: Array[Int]): Array[Int] = {
    val iterator1 = ar1.iterator
    val iterator2 = ar2.iterator

    var el1 = iterator1.next()
    var el2 = iterator2.next()

    val buffer = mutable.Buffer[Int]()

    var enough = true

    while (enough) {
      var toContinue = true
      if (el1 > el2) {
        if(!iterator2.hasNext) toContinue = false
        else el2 = iterator2.next()
      } else if(el2 > el1) {
        if(!iterator1.hasNext) toContinue = false
        else el1 = iterator1.next()
      } else {
        buffer += el1
        if (iterator2.hasNext) while(iterator2.hasNext && el2 == el1) el2 = iterator2.next()
        else toContinue = false
      }
      enough = (iterator1.hasNext || iterator2.hasNext) && toContinue
    }

    buffer.toArray
  }
}

package two.two

import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

import scala.reflect.ClassTag

object Inversions {

  def inversions[T: ClassTag](a: Array[T])(implicit ordered: T => Ordered[T]): Int = {
    val sorter = new ImprovedMergeSortWithInsertion[T]() with ImprovedMergerWithComparsion[T]

    val clone = a.clone()

    sorter.sort(a)

    var res = 0
    for (i <- a.indices) {
      if(a(i) != clone(i)) res += 1
    }

    res
  }
}



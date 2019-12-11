package two.two

import two.one.SortAlgorhitm

abstract class MergeSort[T] extends SortAlgorhitm[T]{
  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    (lo to hi).foreach(i => copyArray(i) = arr(i))

    var leftIndex = lo
    var rightIndex = mid + 1

    for (i <- lo to hi) {
      if (leftIndex > mid)  {arr(i) = copyArray(rightIndex); rightIndex += 1}
      else if(rightIndex > hi) {arr(i) = copyArray(leftIndex); leftIndex += 1}
      else if (copyArray(rightIndex) > copyArray(leftIndex)) {arr(i) = copyArray(leftIndex); leftIndex += 1}
      else  {arr(i) = copyArray(rightIndex); rightIndex += 1}
    }
  }
}

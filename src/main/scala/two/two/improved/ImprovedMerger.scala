package two.two.improved

import two.two.{MergeSort, Merger}

trait ImprovedMerger[T] extends Merger[T] {
  this: MergeSort[T] =>

  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    var leftIndex = lo
    var rightIndex = mid + 1


    if(rightIndex > arr.length - 1) {
      for (i <- lo until arr.length) copyArray(i) = arr(i)
      return
    }

    val actualHi = Math.min(hi, arr.length - 1)
    for (i <- lo to actualHi) {
      if (leftIndex > mid)  {copyArray(i) = arr(rightIndex); rightIndex += 1}
      else if(rightIndex > actualHi) {copyArray(i) = arr(leftIndex); leftIndex += 1}
      else if (arr(rightIndex) > arr(leftIndex)) {copyArray(i) = arr(leftIndex); leftIndex += 1}
      else  {copyArray(i) = arr(rightIndex); rightIndex += 1}
    }
  }
}

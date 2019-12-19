package two.two.kmerge

import scala.reflect.ClassTag

class KCopyMerger[T: ClassTag] (implicit val ord: T => Ordered[T]){
  def merge(firstIndex: Int, k: Int, chunkSize: Int, a: Array[T], copy: Array[T]): Unit = {

    var currentStep = chunkSize
    var merges = - 1
    val maxElement = Math.min(firstIndex + k * chunkSize, a.length)
    var hi = 0
    while(!(merges == 0 || merges == 1 && hi == maxElement - 1)) {
      var beginMerge = firstIndex
      merges = 0

      while (beginMerge + currentStep < maxElement) {
        hi = Math.min(beginMerge + currentStep * 2 - 1, maxElement - 1)
        mergeTwo(a, beginMerge, beginMerge + currentStep - 1, hi, copy)
        beginMerge = hi + 1
        merges += 1
      }
      currentStep *= 2
    }
  }

  private def mergeTwo(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
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

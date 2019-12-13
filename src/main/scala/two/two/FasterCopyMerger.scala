package two.two

trait FasterCopyMerger[T] extends Merger[T] {
  this: MergeSort[T] =>
  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    (lo to mid).foreach(i => copyArray(i) = arr(i))

    var ind = hi
    for (i <- mid + 1 to hi) {
      copyArray(ind) = arr(i)
      ind -= 1
    }

    var leftIndex = lo
    var rightIndex = hi

    ind = lo
    for (_ <- lo to hi) {
      if(copyArray(leftIndex) < copyArray(rightIndex)) {
        arr(ind) = copyArray(leftIndex)
        leftIndex += 1
      } else {
        arr(ind) = copyArray(rightIndex)
        rightIndex -= 1
      }

      ind += 1
    }
  }
}

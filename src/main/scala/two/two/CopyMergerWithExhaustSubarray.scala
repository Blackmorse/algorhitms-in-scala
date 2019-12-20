package two.two

import two.one.tools.UniformArrayGenerator

import scala.collection.mutable

trait CopyMergerWithExhaustSubarray[T] extends Merger[T] {
  this: MergeSort[T] =>

  val leftMap = mutable.Map[Int, Long]()
  val rightMap = mutable.Map[Int, Long]()

  protected def merge(arr: Array[T], lo: Int, mid: Int, hi: Int, copyArray: Array[T]): Unit = {
    (lo to hi).foreach(i => copyArray(i) = arr(i))

    var leftIndex = lo
    var rightIndex = mid + 1

    var leftExhausted = false
    var rightExhausted = false

    for (i <- lo to hi) {
      if (leftIndex > mid) {
        arr(i) = copyArray(rightIndex); rightIndex += 1
        if(!leftExhausted) {
          val N = hi - lo
          leftMap.updateWith(N)({
            case Some(c) => Some( c + 1)
            case None => Some(1)
          })
        }
        leftExhausted = true
      }
      else if (rightIndex > hi) {
        arr(i) = copyArray(leftIndex); leftIndex += 1
        if(!rightExhausted) {
          val N = hi - lo
          rightMap.updateWith(N)({
            case Some(c) => Some( c + 1)
            case None => Some(1)
          })
        }
        rightExhausted = true
      }
      else if (copyArray(rightIndex) > copyArray(leftIndex)) {
        arr(i) = copyArray(leftIndex); leftIndex += 1
      }
      else {
        arr(i) = copyArray(rightIndex); rightIndex += 1
      }
    }

  }
}

object CopyMergerWithExhaustSubarray {
  def main(args: Array[String]): Unit = {
    val sorter = new BottomUpMergeSort[Double]() with CopyMergerWithExhaustSubarray[Double]

    val a = UniformArrayGenerator.generate(10000)

    sorter.sort(a)

    println(sorter.leftMap.toArray.sortBy(_._1).mkString("; "))
    println(sorter.rightMap.toArray.sortBy(_._1).mkString("; "))
  }
}
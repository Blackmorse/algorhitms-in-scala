package two.two

import two.one.tools.UniformArrayGenerator

import scala.reflect.ClassTag

class MergeSortPasses[T: ClassTag](implicit protected val toOrdered: T => Ordered[T]) {

  def passes(a: Array[T]): Int = {
    var ind = 0
    var count = 0
    while(ind < a.length - 1) {
      ind = nextIndex(a, ind) + 1

      count += 1
    }
    (Math.log10(count) / Math.log10(2)).toInt
  }

  private def nextIndex(a: Array[T], lo: Int): Int = {
    var i = lo
    while(i + 1 < a.length && a(i + 1) >= a(i)) i += 1
    i
  }
}

object MergeSortPasses {
  def main(args: Array[String]): Unit = {
    val passesser = new MergeSortPasses[Double]()

    var a= UniformArrayGenerator.generate(1000)

    println(s"1000: ${passesser.passes(a)}")

    a= UniformArrayGenerator.generate(1000000)

    println(s"1000000: ${passesser.passes(a)}")

    a= UniformArrayGenerator.generate(100000000)

    println(s"100000000: ${passesser.passes(a)}")
  }
}
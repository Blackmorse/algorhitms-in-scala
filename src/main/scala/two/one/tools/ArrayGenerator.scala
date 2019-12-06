package two.one.tools

import edu.princeton.cs.algs4.StdRandom
import two.one.ShellSort

import scala.collection.mutable

trait ArrayGenerator[T] {
  implicit protected val toOrdered: T => Ordered[T]
  def generate(n: Int): Array[T]

  def name: String
}

trait DoubleArrayGenerator extends ArrayGenerator[Double] {
  override implicit protected val toOrdered: Double => Ordered[Double] = {
    d => (that: Double) => d.compareTo(that)
  }
}

object UniformArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.uniform())

  override def name: String = "UniformArrayGenerator"

  
}

object SortedArrayGenerator extends DoubleArrayGenerator {
  private val sorter = new ShellSort[Double]()
  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array
  }

  override def name: String = "SortedArrayGenerator"
}

object ReverseOrderArrayGenerator extends DoubleArrayGenerator {
  private val sorter = new ShellSort[Double]()

  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array.reverse
  }

  override def name: String = "ReverseOrderArrayGenerator"
}

object SameElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val element = StdRandom.uniform()
    Array.fill(n)(element)
  }

  override def name: String = "SameElementsArrayGenerator"
}

object TwoElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val el1 = StdRandom.uniform()
    val el2 = StdRandom.uniform()

    Array.fill(n)(if(StdRandom.bernoulli()) el1 else el2)
  }

  override def name: String = "TwoElementsArrayGenerator"
}

object NoElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    Array[Double]()
  }

  override def name: String = "NoElementsArrayGenerator"
}

object OneElementSizeArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array(StdRandom.uniform())

  override def name: String = "OneElementArrayGenerator"
}

object ZeroOneArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(0d)
    for (i <- n / 2 until n) a(i) = 1d
    StdRandom.shuffle(a)
    a
  }

  override def name: String = "ZeroOneArrayGenerator"
}

object IntSequenceArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val buffer = mutable.ArrayBuffer[Double]()

    var t = n / 2 + 1
     do {
      for (i <- 1 to t) {
        buffer += t.toDouble
      }
       if (t == 2) t = 1
       else if (t == 1) t = 0
       else t = t / 2 + 1
    } while( t!= 0)
    val array = buffer.toArray
    StdRandom.shuffle(array)
    array
  }

  override def name: String = "IntSequenceArrayGenerator"
}

object HalfZeroArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(0d)
    for (i <- 0 to n / 2) {
      a(i) = StdRandom.uniform(Int.MinValue, Int.MaxValue).toDouble
    }
    StdRandom.shuffle(a)
    a
  }

  override def name: String = "HalfZeroArrayGenerator"
}

object GaussianArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.gaussian())

  override def name: String = "GaussianArrayGenerator"
}

object PoissonArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.poisson(10))

  override def name: String = "PoissonArrayGenerator"
}

object GeometricArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.geometric(0.5))

  override def name: String = "GeometricArrayGenerator"
}

object LastPercentUnsortedArrayGenerator extends DoubleArrayGenerator {
  val sorter = new ShellSort[Double]()

  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(StdRandom.uniform())
    val lastRandoms = (n * 0.95).toInt
    sorter.sort(a)
    for (i <- n - lastRandoms - 1 until n) a(i) = StdRandom.uniform()

    a
  }

  override def name: String = "LastPercentUnsorted"
}

object SortedExcept10ArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(StdRandom.uniform())
    val sorter = new ShellSort[Double]()
    sorter.sort(a)

    for (_ <- 1 to 5) {
      val index1 = StdRandom.uniform(n)
      val index2 = StdRandom.uniform(n)

      val t = a(index1)
      a(index1) = a(index2)
      a(index2) = t
    }

    a
  }

  override def name: String = "SortedExcept10ArrayGenerator"
}

object SortedExcept5PercentArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] =  {
    val a = Array.fill(n)(StdRandom.uniform())

    val sorter = new ShellSort[Double]()
    sorter.sort(a)

    val unsorted = (n * 0.95).toInt

    for (_ <- 1 to unsorted) {
      val index = StdRandom.uniform(n)
      a(index) = StdRandom.uniform()
    }

    a
  }

  override def name: String = "SortedExcept5PercentArrayGenerator"
}
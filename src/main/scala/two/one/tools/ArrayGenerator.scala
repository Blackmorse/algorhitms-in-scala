package two.one.tools

import java.util.UUID

import edu.princeton.cs.algs4.StdRandom
import two.one.ShellSort

import scala.collection.mutable

trait ArrayGenerator[T] {
  implicit  val toOrdered: T => Ordered[T]
  def generate(n: Int): Array[T]
}

trait DoubleArrayGenerator extends ArrayGenerator[Double] {
  override implicit  val toOrdered: Double => Ordered[Double] = {
    d => (that: Double) => {
      if (d > that ) 1 else 0
    }
  }
}

object UniformArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.uniform())
}

object SortedArrayGenerator extends DoubleArrayGenerator {
  private val sorter = new ShellSort[Double]()
  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array
  }
}

object ReverseOrderArrayGenerator extends DoubleArrayGenerator {
  private val sorter = new ShellSort[Double]()

  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array.reverse
  }
}

object SameElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val element = StdRandom.uniform()
    Array.fill(n)(element)
  }
}

object TwoElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val el1 = StdRandom.uniform()
    val el2 = StdRandom.uniform()

    Array.fill(n)(if(StdRandom.bernoulli()) el1 else el2)
  }
}

object NoElementsArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    Array[Double]()
  }
}

object OneElementSizeArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array(StdRandom.uniform())
}

object ZeroOneArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(0d)
    for (i <- n / 2 until n) a(i) = 1d
    StdRandom.shuffle(a)
    a
  }
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
}

object HalfZeroArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(0d)
    for (i <- 0 to n / 2) {
      a(i) = StdRandom.uniform(Double.MinValue, Double.MaxValue)
    }
    StdRandom.shuffle(a)
    a
  }
}

object PartZeroArrayGenerator {
  def apply(part: Double) = new PartZeroArrayGenerator(part)
}

class PartZeroArrayGenerator(part: Double) extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val a = Array.fill(n)(0d)
    for (i <- 0 to ((n * (1 - part)) - 1).toInt ) {
      a(i) = StdRandom.uniform()
    }
    StdRandom.shuffle(a)
    a
  }
}

object GaussianArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.gaussian())
}

object PoissonArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.poisson(10))
}

object GeometricArrayGenerator extends DoubleArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.geometric(0.5))
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
}

object StringDoubleKeyArrayGenerator extends ArrayGenerator[(String, Double)]{
  override implicit  val toOrdered: ((String, Double)) => Ordered[(String, Double)] = {case (s, d) =>
    (that: (String, Double)) => s.compareTo(that._1)
  }

  override def generate(n: Int): Array[(String, Double)] = {
    Array.fill(n)((UUID.randomUUID().toString, StdRandom.uniform()))
  }
}

object DoubleArrayStringGenerator extends ArrayGenerator[(Double, Array[String])] {
  override implicit  val toOrdered: ((Double, Array[String])) => Ordered[(Double, Array[String])] = {case(d, ar) =>
    (that: (Double, Array[String])) => d.compareTo(that._1)
  }

  override def generate(n: Int): Array[(Double, Array[String])] = {
    Array.fill(n)((StdRandom.uniform(), Array.fill(10)(UUID.randomUUID().toString)))
  }
}

object IntKeyIntArrayGenerator extends ArrayGenerator[(Int, Array[Int])] {
  override implicit val toOrdered: ((Int, Array[Int])) => Ordered[(Int, Array[Int])] = {case(i, ar) =>
    (that: (Int, Array[Int])) => i.compareTo(that._1)
  }

  override def generate(n: Int): Array[(Int, Array[Int])] = {
    Array.fill(n)((StdRandom.uniform(Int.MinValue, Int.MaxValue), Array.fill(20)(StdRandom.uniform(Int.MinValue, Int.MaxValue))))
  }
}
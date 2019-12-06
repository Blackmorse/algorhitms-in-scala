package two.one.tools

import edu.princeton.cs.algs4.StdRandom
import two.one.ShellSort

trait ArrayGenerator {
  def generate(n: Int): Array[Double]
}

object UniformArrayGenerator extends ArrayGenerator {
  override def generate(n: Int): Array[Double] = Array.fill(n)(StdRandom.uniform())
}

object SortedArrayGenerator extends ArrayGenerator {
  private val sorter = new ShellSort[Double]()
  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array
  }
}

object ReverseOrderArrayGenerator extends ArrayGenerator {
  private val sorter = new ShellSort[Double]()

  override def generate(n: Int): Array[Double] = {
    val array = Array.fill(n)(StdRandom.uniform())
    sorter.sort(array)
    array.reverse
  }
}

object SameElementsArrayGenerator extends ArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val element = StdRandom.uniform()
    Array.fill(n)(element)
  }
}

object TwoElementsArrayGenerator extends ArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    val el1 = StdRandom.uniform()
    val el2 = StdRandom.uniform()

    Array.fill(n)(if(StdRandom.bernoulli()) el1 else el2)
  }
}

object NoElementsArrayGenerator extends ArrayGenerator {
  override def generate(n: Int): Array[Double] = {
    Array[Double]()
  }
}

object OneElementArrayGenerator extends ArrayGenerator {
  override def generate(n: Int): Array[Double] = Array(StdRandom.uniform())
}


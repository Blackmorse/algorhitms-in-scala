package two.one.tools

import two.one.{InsertionSort, SelectionSort, ShellSort, SortAlgorhitm}

import scala.collection.mutable

object DoublingTest {
  def test[T](algorhitm: SortAlgorhitm[T], n: Int = 1000,
           t: Int = 10,
           attempts: Int = 10,
           arrayGenerator: ArrayGenerator[T],
              draw: Boolean = true) (implicit toOrdered: T => Ordered[T]) = {

    var N = n

    var previousTime: Double = Double.NaN

    val data = mutable.Buffer[(Int, Double)]()

    for (_ <- 1 to 10) {

      val totalTime = 1.to(t).map(_ => {
        val a = arrayGenerator.generate(N)
        val t1 = System.currentTimeMillis()
        algorhitm.sort(a)
        System.currentTimeMillis() - t1
      }).sum

      val time = totalTime.toDouble / t

      data += ((N, time))
      if (draw) one.four.DoublingTest.draw(data.toSeq)

      val timeRatio = if (previousTime == Double.NaN) Double.NaN else time / previousTime

      println(s"n: $N. time: $time. Ratio: $timeRatio")

      previousTime = time
      N *= 2
    }
    println("end")
  }


  def main(args: Array[String]): Unit = {
//    test(algorhitm = new ShellSort[Double](), arrayGenerator = UniformArrayGenerator, draw = false)

    implicit  val ord = DoubleArrayStringGenerator.toOrdered

    test(algorhitm = new ShellSort[(Double, Array[String])], arrayGenerator = DoubleArrayStringGenerator, draw = false)
  }
}

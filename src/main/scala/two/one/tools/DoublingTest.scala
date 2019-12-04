package two.one.tools

import edu.princeton.cs.algs4.StdRandom
import two.one.{InsertionSort, SortAlgorhitm}

object DoublingTest {
  def test(algorhitm: SortAlgorhitm[Double], n : Int = 1000, t: Int = 10, attempts: Int = 10) = {

    var N = n

    var previousTime: Double = Double.NaN

    for (i <- 1 to 10) {

      val totalTime = 1.to(t).map(_ => {
        val a = Array.fill(N)(StdRandom.uniform())
        val t1 = System.currentTimeMillis()
        algorhitm.sort(a)
        System.currentTimeMillis() - t1
      }).sum

      val time = totalTime.toDouble / t

      val timeRatio = if(previousTime == Double.NaN) Double.NaN else time / previousTime

      println(s"n: $N. time: $time. Ratio: $timeRatio")

      previousTime = time
      N *= 2
    }
  }


  def main(args: Array[String]): Unit = {
    test(new InsertionSort[Double]())
    }
}

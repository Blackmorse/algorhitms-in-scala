package two.one.tools

import java.awt.Color

import common.{Chart, Plot}
import two.one._
import two.two.{BottomUpMergeSort, CopyMerger, FasterCopyMerger, TopDownMergeSort}

import scala.collection.mutable

object DoublingTest {
  def test[T](n: Int = 1000,
           t: Int = 10,
           attempts: Int = 10,
           arrayGenerator: ArrayGenerator[T],
              draw: Boolean = true,
              algorhitms: Seq[SortAlgorhitm[T]])
             (implicit toOrdered: T => Ordered[T]) = {

    var N = n

    val colors = Array(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE)

    val datas = Array.fill(algorhitms.length)(mutable.Buffer[(Double, Double)]())
    val previousTimes = Array.fill(algorhitms.size)(Double.NaN)
    for (attempt <- 1 to attempts) {

      println(s"attempt: $attempt")
      val arrays = 1.to(t).map(_ => arrayGenerator.generate(N))

      for (algor <- algorhitms.indices) {
        val algorhitm = algorhitms(algor)

        val totalTime = arrays.map(a => {
//          val a = arrayGenerator.generate(N)
          val t1 = System.currentTimeMillis()
          algorhitm.sort(a)
          System.currentTimeMillis() - t1
        }).sum

        val time = totalTime.toDouble / t

        val data = datas(algor)
        data += ((N, time))

        val timeRatio = if (previousTimes(algor) == Double.NaN) Double.NaN else time / previousTimes(algor)

        println(s"n: $N. time: $time. Ratio: $timeRatio")

        previousTimes(algor) = time

      }

      if (draw) {
        val values = algorhitms.zipAll(colors, null, Color.BLACK).zip(datas)
        val plot = new Plot()
        values.foreach{case((algorhitm, color), data) => plot.addChart(data.toSeq, color, algorhitm.getClass.getSimpleName)}
        plot.dots(true)
        plot.draw
      }


      println("------")
      N *= 2
    }




    println("end")
  }


  def main(args: Array[String]): Unit = {
//    test(algorhitm = new ShellSort[Double](), arrayGenerator = UniformArrayGenerator, draw = false)

//    implicit  val ord = DoubleArrayStringGenerator.toOrdered

    test(n = 1000, t = 20, attempts = 15, arrayGenerator = UniformArrayGenerator, draw = true, algorhitms =
      Seq(new TopDownMergeSort[Double]() with CopyMerger[Double],
        new TopDownMergeSort[Double]() with FasterCopyMerger[Double],
      new BottomUpMergeSort[Double]() with CopyMerger[Double],
      new BottomUpMergeSort[Double]() with FasterCopyMerger[Double]
    ) )
  }
}

package scala.common

import edu.princeton.cs.algs4.{StdDraw, StdRandom}

class Histogram {

}

object Histogram {
  def draw(data: Seq[Int]): Unit = {
    val maxKey = data.max
    val minKey = data.min

    val a = data.groupBy(identity).map{case(value, list) => (value -> list.length)}.toSeq
    val maxValue = a.maxBy(_._2)._2

    val zeros = minKey.to(maxKey).filter(i => !data.contains(i)).map(i => i -> 0)

    val fullData = (zeros ++ a).sortBy(_._1)

    println(fullData.mkString(", "))

    val areaHorizontal = (0.1, 0.9)
    val areaVertical = (0.1, 0.9)

    StdDraw.setPenColor(StdDraw.GRAY)
    StdDraw.rectangle(0.5, 0.5, 0.42, 0.42)

    StdDraw.text(0.05, 0.9, maxValue.toString)

    val intervalWidth = (areaHorizontal._2 - areaHorizontal._1) / (maxKey - minKey + 1)

    StdDraw.setPenColor(StdDraw.BLACK)

    val labelFreq = fullData.length / 5

    for((interval, index) <- fullData.zipWithIndex) {
      val x = areaHorizontal._1 + intervalWidth * (interval._1 - minKey) + intervalWidth / 2
      val height = (areaVertical._2 - areaVertical._1) * interval._2 / maxValue

      StdDraw.setPenColor(StdDraw.RED)
      StdDraw.filledRectangle(x, areaVertical._1 + height / 2, intervalWidth / 2, height / 2)

      StdDraw.setPenColor(StdDraw.BLACK)
      StdDraw.rectangle(x, areaVertical._1 + height / 2, intervalWidth / 2, height / 2)


      if (index % labelFreq == 0 || index == fullData.length - 1) {
        StdDraw.text(x, 0.05, interval._1.toString)
      }
    }
  }


  def main(args: Array[String]): Unit = {
    val data = LazyList.continually((StdRandom.gaussian() * 20).toInt ).take(100000).toSeq

    draw(data)
  }
}
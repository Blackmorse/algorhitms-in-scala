package common

import java.awt.Color

import edu.princeton.cs.algs4.StdDraw

import scala.collection.mutable

case class Chart(data: Seq[(Double, Double)], color: Color, name: String) {
  def scale(maxX: Double, minX: Double, maxY: Double, minY: Double) : Chart = {
    val data = this.data
      .map{case (x,y) =>((x - minX) * 0.9 / (maxX - minX), (y - minY) * 0.9 / (maxY - minY))}
      .map{case (x, y) => (x + 0.05, y + 0.05)}

    Chart(data, color, name)
  }

  def log(): Chart = {
    val data = this.data
      .map{case (x, y) =>  (Math.log(1 + x), Math.log(y)) }

    Chart(data, color, name)
  }
}

class Plot {
  private val charts = mutable.Buffer[Chart]()

  private var logPlot = false
  private var drawDots = true

  def addChart(data: Seq[(Double, Double)], color: Color, name: String = ""): Plot = {
    charts += Chart(data, color, name)
    this
  }

  def log(b: Boolean = true): Plot = {
    logPlot = b
    this
  }

  def dots(b: Boolean = false): Plot = {
    drawDots = b
    this
  }

  def draw: Unit = {
    val charts = if(logPlot) this.charts.map(_.log()) else this.charts

    val maxX = charts.map(chart => chart.data.maxBy(_._1)._1).max
    val minX = charts.map(chart => chart.data.minBy(_._1)._1).min
    val maxY = charts.map(chart => chart.data.maxBy(_._2)._2).max
    val minY = charts.map(chart => chart.data.minBy(_._2)._2).min

    val scaledCharts = charts.map(chart => chart.scale(maxX, minX, maxY, minY))

    StdDraw.clear()
    StdDraw.setPenColor(Color.BLACK)
    StdDraw.setPenRadius()

    val y = if (minY < 0) -minY * 0.9 / (maxY - minY) + 0.05 else 0.025

    StdDraw.line(0d, y, 1d, y)

    StdDraw.line(0.025d, 0, 0.025d, 1d)

    StdDraw.setPenRadius(0.01)
    StdDraw.point(0.95, y)
    StdDraw.text(0.95, y - 0.018, maxX.toString)

    StdDraw.point(0.025, 0.95)
    StdDraw.text(0.08, 0.95, maxY.toString)

    scaledCharts.foreach(drawChart)
    drawLegend(scaledCharts.toSeq)
  }

  private def drawChart(chart: Chart): Unit = {
    val data = chart.data
    StdDraw.setPenRadius()
    StdDraw.setPenColor(chart.color)

    for (i <- 0 until data.length - 1) {
      StdDraw.line(data(i)._1, data(i)._2, data(i + 1)._1, data(i + 1)._2)
    }

    StdDraw.setPenRadius(0.01d)

    if (drawDots) {
      for (point <- data) {
          StdDraw.point(point._1, point._2)
      }
    }
  }

  private def drawLegend(charts: Seq[Chart]) = {
    for (i <- charts.indices if charts(i).name != "") {
      val chart = charts(i)
      StdDraw.setPenRadius()
      StdDraw.setPenColor(chart.color)
      StdDraw.line(0.03 + 0.2 * i , 0.012d, 0.03 + 0.05 + 0.2 * i , 0.012d)

      StdDraw.text(0.03 + 0.05 + 0.05 + 0.2 * i, 0.012d, chart.name)
    }
  }
}

object Drawer {
  def main(args: Array[String]): Unit = {
    val data = 1.to(20).map(i => (i.toDouble, 5 * i.toDouble))

    val data2 = 1.to(20).map(i => (i.toDouble, 15 * i.toDouble))
    new Plot().addChart(data, Color.BLACK, "black")
      .addChart(data2, Color.RED, "red")
//      .log(true)
      .draw
  }
}

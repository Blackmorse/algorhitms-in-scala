package common

import java.awt.Color

import edu.princeton.cs.algs4.StdDraw

import scala.collection.mutable

case class Chart(data: Seq[(Double, Double)], color: Color) {
  def scale(maxX: Double, minX: Double, maxY: Double, minY: Double) : Chart = {
    val data = this.data
      .map{case (x,y) =>((x - minX) * 0.9 / (maxX - minX), (y - minY) * 0.9 / (maxY - minY))}
      .map{case (x, y) => (x + 0.05, y + 0.05)}

    Chart(data, color)
  }

  def log(): Chart = {
    val data = this.data
      .map{case (x, y) =>  (Math.log(1 + x), Math.log(y)) }

    Chart(data, color)
  }
}

class Plot {
  private val charts = mutable.Buffer[Chart]()

  private var logPlot = false

  def addChart(data: Seq[(Double, Double)], color: Color): Plot = {
    charts += Chart(data, color)
    this
  }

  def log(b: Boolean): Plot = {
    logPlot = b
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

    StdDraw.setPenRadius()

    if (minY < 0) {
      val y = -minY * 0.9 / (maxY - minY) + 0.05
      StdDraw.line(0d, y, 1d, y)
    } else {
      StdDraw.line(0d, 0.025d, 1d, 0.025d)
    }
    StdDraw.line(0.025d, 0, 0.025d, 1d)

    scaledCharts.foreach(drawChart)
  }

  private def drawChart(chart: Chart): Unit = {
    val data = chart.data
    StdDraw.setPenRadius()
    StdDraw.setPenColor(chart.color)

    for (i <- 0 until data.length - 1) {
      StdDraw.line(data(i)._1, data(i)._2, data(i + 1)._1, data(i + 1)._2)
    }

    StdDraw.setPenRadius(0.01d)
    for (point <- data) {
      StdDraw.point(point._1, point._2)
    }
  }
}

object Drawer {
  def main(args: Array[String]): Unit = {
    val data = 1.to(20).map(i => (i.toDouble, i.toDouble))

    val data2 = 1.to(20).map(i => (i.toDouble, -i.toDouble))
    new Plot().addChart(data, Color.BLACK)
      .addChart(data2, Color.RED)
//      .log(true)
      .draw
  }
}

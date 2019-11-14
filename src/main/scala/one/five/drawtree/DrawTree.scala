package one.five.drawtree

import java.util.concurrent.TimeUnit

import edu.princeton.cs.algs4.{StdDraw, StdIn, StdRandom}
import one.five.{QuickUnionUF, WeightedQuickUnionUF}

import scala.collection.mutable

case class DrawTreeNode(value: Int, childs: mutable.Buffer[DrawTreeNode] = mutable.Buffer(), var parent: Option[DrawTreeNode] = None) {

}

object DrawTree {
  def rootNodes(a: Array[Int]) = {
    val nodes = a.indices.toArray.map(i => i -> DrawTreeNode(i)).toMap

    a.indices.foreach(i => {
      if (a(i) != i) {
        nodes(i).parent = Some(nodes(a(i)))
        nodes(a(i)).childs += nodes(i)
      }
    })

    nodes.values.filter(_.parent.isEmpty).toArray
  }

  def treeNodesArray(node: DrawTreeNode): Array[Array[(Int, Int)]] = {
    var continue = true
    var res = mutable.Buffer[Array[DrawTreeNode]]()

    var newNodes = Array(node)

    while (continue) {
      res += newNodes

      newNodes = newNodes.map(_.childs).flatten
      if(newNodes.isEmpty) continue = false
    }

    val array = res.toArray

    val numbers = array.indices.reverse.map(ind => {
      val a = if (ind != 0) {
        val prevLine = array(ind - 1)
        val curLine = array(ind)
        val aa = curLine.indices.map(ci => (curLine(ci).value, prevLine.indexOf(curLine(ci).parent.get))).toArray
        aa
      } else {
        val aa = Array((array(0)(0).value, -1))
        aa
      }
      a
    }).toArray.reverse

    numbers
  }

  def draw(a: Array[Int]) = {
    val roots = rootNodes(a).sortBy(_.value)

    val partitions = for (root <- roots) yield treeNodesArray(root)

    val partitionsWithWidths = partitions.map(partition => (partition.map(_.length).max, partition))

    val total = partitionsWithWidths.map(_._1).sum + partitionsWithWidths.length

    var prev = 0.00d

    partitionsWithWidths.zipWithIndex.foreach{case((width, array), _) => {
        val interval = 0.9 / total

        val min = prev + interval
        val max = min + interval * width
        prev = max

        drawArray(min, max, array)
      }
    }
  }

  case class Point(x: Double, y: Double)

  def drawArray(min: Double, max: Double, a: Array[Array[(Int, Int)]]): Unit = {
    val baseY = 0.9


    val pointss = for (lineIndex <- a.indices) yield {
      val lineArray = a(lineIndex)
      if (lineIndex == 0) {
        val v = Array((Point(min + (max - min) / 2, baseY - lineIndex * 0.1), lineArray(0)._1, -1))
        v
      } else if(lineArray.length == 1) {
        val v = Array((Point(min + (max - min) / 2, baseY - lineIndex * 0.1), lineArray(0)._1, lineArray(0)._2))
        v
      } else {
        val segment = (max - min) / (lineArray.length - 1)
        val v = lineArray.indices.map(i => (min + segment * i, lineArray(i)._1, lineArray(i)._2))
          .map{case(x, value, link) => (Point(x, baseY - lineIndex * 0.1), value, link)}.toArray
        v
      }
    }


    val res = for (lineIndex <- pointss.indices) yield {
      val lineArray = pointss(lineIndex)
      if (lineIndex == 0) {
        Array((lineArray(0)._1, lineArray(0)._2, null: Point))
      } else {
        lineArray.map{case (point, value, link) => (point, value, pointss(lineIndex - 1)(link)._1)}
      }
    }


    res.flatten.foreach{case(point, value, nextPoint) =>
      StdDraw.setPenRadius(0.03)
      StdDraw.point(point.x, point.y)
      StdDraw.textRight(point.x - 0.02, point.y - 0.01, value.toString)
      if (nextPoint != null) {
        StdDraw.setPenRadius(0.005)
        StdDraw.line(point.x, point.y, nextPoint.x, nextPoint.y)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val a = Array(1,2,2,2,5,6,6,6)


    val uf = new WeightedQuickUnionUF(10)


    for (i <- 1 to 10) {


      val a = StdIn.readInt()
      val b = StdIn.readInt()

      StdDraw.clear()

      if (a != b) uf.union(a, b)

      draw(uf.id)

    }
  }
}

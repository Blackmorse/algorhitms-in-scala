package one.one

import scala.collection.mutable

object TrueFalseArray {

  def main(args: Array[String]): Unit = {
    TrueFalseArray(15).map(_.mkString(",")).foreach(println(_))
  }

  def apply(n: Int): Array[Array[Boolean]] = {
      val buffers = 1.to(n).toArray.map(_ => mutable.Buffer[Boolean]())

      for (i <- 0 until n; j <- 0 until n) {
        buffers(i) += Euclid.doAlg(i, j) == 1
      }
      buffers.map(buffer => buffer.toArray)
  }
}

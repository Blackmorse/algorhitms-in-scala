package one.three

import edu.princeton.cs.algs4.StdIn
import one.two.TransactionClient

object TransactionArray {
  def read(): Unit = {
    LazyList.continually(StdIn.readString()).takeWhile(_ != "end").map(TransactionClient(_)).toArray
  }
}

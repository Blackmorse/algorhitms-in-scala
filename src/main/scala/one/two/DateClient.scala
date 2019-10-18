package one.two

import edu.princeton.cs.algs4.Date

object DateClient {
  def apply(date: String) =
  {
    val fields = date.split("/")
    val month = fields(0).toInt
    val day = fields(1).toInt
    val year = fields(2).toInt

    new Date(month, day, year)
  }
}

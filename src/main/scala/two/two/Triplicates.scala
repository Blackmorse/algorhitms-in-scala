package two.two

import two.two.improved.{ImprovedMergeSortWithInsertion, ImprovedMergerWithComparsion}

object Triplicates {
  def find(first: Array[String], second: Array[String], third: Array[String]): Option[String] = {
    val sorter = new ImprovedMergeSortWithInsertion[String]() with ImprovedMergerWithComparsion[String]

    sorter.sort(first)
    sorter.sort(second)
    sorter.sort(third)

    var i1 = 0
    var i2 = 0
    var i3 = 0

    while (true) {
      if (first.length == i1 || second.length == i2 || third.length == i3) return None
      else if(first(i1) == second(i2) && second(i2) == third(i3)) return Some(first(i1))
      else if(first(i1) < second(i2) || first(i1) < third(i3)) i1 += 1
      else if(second(i2) < first(i1) || second(i2) < third(i3)) i2 += 1
      else if(third(i3) < first(i1) || third(i3) < second(i2)) i3 += 1
    }

    None
  }

  def main(args: Array[String]): Unit = {
    val a = Array("a", "b", "c")
    val b = Array("a1", "b1", "c1")
    val c = Array("a2", "b2", "c2")

    val r = find(a, b, c)

    println(r)
  }
}
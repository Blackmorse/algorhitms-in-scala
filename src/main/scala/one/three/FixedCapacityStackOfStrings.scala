package one.three

class FixedCapacityStackOfStrings(val cap: Int) {
  val a: Array[String] = Array.fill(cap)(null)

  private var n = 0 // size

  def isEmpty = n == 0

  def size: Int = n

  def push(item: String): Unit = {
    a(n) = item
    n += 1
  }

  def pop: String = a({
    n -= 1; n
  })

  def isFull: Boolean = n == cap
}

object FixedCapacityStackOfStrings {
  def main(args: Array[String]): Unit = {
    new FixedCapacityStackOfStrings(5).push("1")
  }

}

package one.three

object StackPermutation {

  def alg(numbers: Array[Int]): Queue[String] = {

    val stack = new Stack[Int]()
    var lastPushed = 0

    val result = new Queue[String]()
    result.enqueue("push 0")
    stack.push(0)

    for (number <- numbers) {
      if (stack.peek() <  number) {
        while (lastPushed != number) {
          lastPushed += 1
          result.enqueue(s"push $lastPushed")
          stack.push(lastPushed)
        }
        result.enqueue(s"pop")
        stack.pop
      } else {
        if (stack.pop == number) {
          result.enqueue("pop")
        } else {
          throw new Exception("Illegal sequence")
        }
      }
    }

    result
  }

  def main(args: Array[String]): Unit = {
    val arr = Array(4,6,8,7,5,3,2,9,0,1)
    val res = alg(arr)

    res.foreach(println)
  }
}

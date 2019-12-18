package two.two

import edu.princeton.cs.algs4.StdRandom
import one.three.{LinkedList, Node, Stack}

//Isn't fair shuffle....
object ShuffleList {

  case class Links[T](previous: Node[T], left: Node[T],
                      right: Node[T], next: Node[T])

  def shuffle[T](list: LinkedList[T]): Unit = {
    val stepStack = new Stack[Int]
    val linksStack = new Stack[Links[T]]()

    stepStack.push(1)
    //<change>

    val first = list.first
    val second = first.next
    val third = second.next
    if (StdRandom.bernoulli()) {
      list.first = second
      first.next = third
      second.next = first

      linksStack.push(Links(null, second, first, third))
    } else {
      linksStack.push(Links(null, first, second, third))
    }

    while(true) {

      val t = stepStack.pop

      if (stepStack.peek() != t && linksStack.peek().next != null) {
        stepStack.push(t)
        stepStack.push(1)

        //<change>
        val links = linksStack.peek()

        val prev = links.right
        val first = links.next
        val second = first.next
        if (second == null) {
          linksStack.push(Links(prev, first, first, null))
        } else {
          val third = second.next
          if(StdRandom.bernoulli()) {
            prev.next = second
            first.next = third
            second.next = first

            linksStack.push(Links(prev, second, first, third))
          } else {
            linksStack.push(Links(prev, first, second, third))
          }
        }
      } else {
        val t2 = stepStack.pop
        stepStack.push(t + t2)

        val rightLinks = linksStack.pop
        val leftLinks = linksStack.pop

        if(StdRandom.bernoulli()) {
          if (leftLinks.previous == null) list.first = rightLinks.left else leftLinks.previous.next = rightLinks.left
          rightLinks.right.next = leftLinks.left
          leftLinks.right.next = rightLinks.next


          linksStack.push(Links(leftLinks.previous, rightLinks.left, leftLinks.right, rightLinks.next))
        } else {
          linksStack.push(Links(leftLinks.previous, leftLinks.left, rightLinks.right, rightLinks.next))
        }
        if (linksStack.peek().previous == null && linksStack.peek().next == null) return
      }
    }
  }
}


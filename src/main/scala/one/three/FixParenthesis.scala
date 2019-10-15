package one.three

object FixParenthesis {

  def fix(input: String) = {
    val exprStack = new Stack[String]
    exprStack.push("")
    val operatorsStack = new Stack[Char]
    var inExpr = true

    for (ch <- input) {
      ch match {
        case '+' | '*' | '-' | '/' => operatorsStack.push(ch); inExpr = false
        case ')' =>
          val right = exprStack.pop
          val left = exprStack.pop
          val op = operatorsStack.pop
          exprStack.push(s"($left $op $right)")
          inExpr = false
        case ' ' => ;
        case ex =>
          val e = if (inExpr) exprStack.pop else ""
          exprStack.push(e + ex)
          inExpr = true
      }
    }
    exprStack.pop
  }

  def main(args: Array[String]): Unit = {

    val r = fix("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )")
    println(r)
  }
}

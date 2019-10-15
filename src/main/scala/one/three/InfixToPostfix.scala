package one.three

object InfixToPostfix {
  def evaluate(input: String) = {
    val operators = new Stack[Char]
    val exprs = new Stack[String]

    var inExpr = false

    for (char <- input) {
      char match {
        case '+' | '-' | '*' | '/' => operators.push(char); inExpr = false
        case ' ' => ;
        case '('=> inExpr = false;
        case ')' =>
          val operator = operators.pop
          val right = exprs.pop
          val left = exprs.pop
          exprs.push(s"($left, $right)$operator")
        case _ =>
          if (!inExpr) {
            inExpr = true
            exprs.push(char.toString)
          } else {
            val pop = exprs.pop
            exprs.push(pop + char.toString)
          }
      }
    }
    exprs.pop
  }
}

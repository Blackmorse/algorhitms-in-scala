package one.three

object EvaluatePostFix {
  def evaluate(input: String): Int = {
    val exprs = new Stack[String]

    var inExpr = false

    for (char <- input) {
      char match {
        case '+' | '-' | '*' | '/' =>
          val right = exprs.pop.toInt
          val left = exprs.pop.toInt
          inExpr = false
          val r = char match {
            case '+' => left + right
            case '-' => left - right
            case '*' => left * right
            case '/' => left / right
          }
          exprs.push(r.toString)
        case '(' | ')' | ',' => inExpr = false
        case ' ' => ;
        case _ => if (!inExpr) {
          inExpr = true
          exprs.push(char.toString)
        } else {
          val pop = exprs.pop
          exprs.push(pop + char.toString)
        }
      }
    }

    exprs.pop.toInt
  }
}

package one.three

object Parentheses {
  val openBrackets = "([{"
  val closeBrackets = ")]}"

  def determine(input: String): Boolean = {
    val stack = new Stack[Char]
    for (char <- input) {
      if (openBrackets.contains(char)) stack.push(char)
      else if (closeBrackets.contains(char)) {
        if (stack.isEmpty) return false
        val pop = stack.pop
        if (!bracketsMatches(pop, char)) return false
      }
    }
    stack.isEmpty
  }

  private def bracketsMatches(openBracket: Char, closeBracket: Char): Boolean = {
    val index = openBrackets.indexOf(openBracket)
    closeBracket == closeBrackets(index)
  }
}

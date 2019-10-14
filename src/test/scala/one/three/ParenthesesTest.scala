package one.three

import org.scalatest.FunSuite

class ParenthesesTest extends FunSuite {
  test("test true") {
    assert(Parentheses.determine("[()]{}{[()()]()}"))
  }

  test("test false") {
    assert(!Parentheses.determine("[(])"))
    assert(!Parentheses.determine("[[([)]]]"))
    assert(!Parentheses.determine("([()]"))
    assert(!Parentheses.determine("[()])"))
  }
}

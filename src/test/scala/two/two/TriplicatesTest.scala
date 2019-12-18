package two.two

import org.scalatest.FunSuite
import two.two.Triplicates.find

class TriplicatesTest extends FunSuite {
  test("test none") {
    val a = Array("a", "b", "c")
    val b = Array("a1", "b1", "c1")
    val c = Array("a2", "b2", "c2")

    assert(find(a, b, c).isEmpty)
  }

  test( "testExist") {
    val a = Array("a", "b", "c", "d", "e")
    val b = Array("a1", "e", "b1", "c1")
    val c = Array("a2", "b2", "c2","e", "f")

    assert(find(a, b, c) == Some("e"))
  }
}

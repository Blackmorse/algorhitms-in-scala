package one.three

import org.scalatest.FunSuite

class BufferTest extends FunSuite {
  test("test buffer") {
    val buffer = new Buffer

    "Hello world".foreach(buffer.insert)

    buffer.left(4)
    assert(buffer.delete() == 'w')
    assert(buffer.delete() == ' ')
    assert(buffer.delete() == 'o')
    buffer.right(2)
    assert(buffer.delete() == 'r')
  }
}

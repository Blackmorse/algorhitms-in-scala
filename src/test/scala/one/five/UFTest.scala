package one.five

import org.scalatest.{BeforeAndAfter, FunSuite}

abstract class UFTest extends FunSuite with BeforeAndAfter {
  var uf: UF = _

  test("test add") {
    uf.union(1, 2)
    uf.union(2, 3)
    uf.union(4, 5)

    assert(uf.find(1) == uf.find(2))
    assert(uf.find(1) == uf.find(3))
    assert(uf.find(4) != uf.find(3))
    assert(uf.find(4) == uf.find(5))

    assert(uf.find(6) != uf.find(7))
    assert(uf.find(6) != uf.find(1))
    assert(uf.find(6) != uf.find(2))
  }
}

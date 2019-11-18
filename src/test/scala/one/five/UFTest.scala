package one.five

import org.scalatest.{BeforeAndAfter, FunSuite}

abstract class UFTest extends FunSuite with BeforeAndAfter {
  var uf: UF = _

  test("test add") {
    assert(uf.count == 10)

    uf.union(1, 2)
    assert(uf.count == 9)
    uf.union(2, 3)
    assert(uf.count == 8)
    uf.union(4, 5)
    assert(uf.count == 7)


    assert(uf.find(1) == uf.find(2))
    assert(uf.find(1) == uf.find(3))
    assert(uf.find(4) != uf.find(3))
    assert(uf.find(4) == uf.find(5))

    assert(uf.find(6) != uf.find(7))
    assert(uf.find(6) != uf.find(1))
    assert(uf.find(6) != uf.find(2))
  }

  test("test 2") {
    uf.union(0, 1)
    uf.union(1, 2)
    uf.union(3, 2)
    uf.union(3, 4)

    assert(uf.find(0) == uf.find(1))
    assert(uf.find(1) == uf.find(2))
    assert(uf.find(2) == uf.find(3))
    assert(uf.find(4) == uf.find(0))
    assert(uf.find(2) == uf.find(4))
  }

  test("test 3") {
    uf.union(1, 0 )
    uf.union(1, 2)
    uf.union(2,3)
    uf.union(3,4)

    uf.union(5, 6 )
    uf.union(6, 7)
    uf.union(7,8)
    uf.union(8,9)

    uf.union(9, 3)

    assert(uf.find(7) == uf.find(3))
  }
}

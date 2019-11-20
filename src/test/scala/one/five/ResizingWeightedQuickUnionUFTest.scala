package one.five

import org.scalatest.FunSuite

class ResizingWeightedQuickUnionUFTest extends FunSuite {
  test("test") {
    val uf = new ResizingWeightedQuickUnionUF

    assert(uf.count == 0)

    uf.newSite
    uf.newSite

    assert(uf.count == 2)

    uf.union(0, 1)

    assert(uf.find(0) == uf.find(1))
    assert(uf.count == 1)

    uf.newSite
    uf.newSite

    assert(uf.count == 3)

    uf.union(2, 3)
    assert(uf.find(2) == uf.find(3))

    uf.union(0, 2)
    assert(uf.count == 1)
  }
}

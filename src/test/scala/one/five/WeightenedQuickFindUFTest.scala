package one.five

class WeightenedQuickFindUFTest extends UFTest {
  before {
    uf = new WeightenedQuickFindUF(10)
  }

  test("test adding to larger component") {
    uf = new WeightenedQuickFindUF(10)

    uf.union(1, 2)

    assert(uf.id(1) == 2)
    assert(uf.id(2) == 2)

    uf.union(4, 1)

    assert(uf.id(4) == 2)
    assert(uf.id(1) == 2)
    assert(uf.id(2) == 2)

    uf.union(5, 6)

    uf.union(1, 5)

    assert(uf.id(5) == 2)
    assert(uf.id(6) == 2)
    assert(uf.id(1) == 2)
    assert(uf.id(2) == 2)

    uf.union(0, 5)

    assert(uf.id(0) == 2)
    assert(uf.id(2) == 2)
    assert(uf.id(1) == 2)
    assert(uf.id(5) == 2)
    assert(uf.id(6) == 2)
  }
}

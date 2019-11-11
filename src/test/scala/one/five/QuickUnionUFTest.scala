package one.five

import org.scalatest.FunSuite

class QuickUnionUFTest extends UFTest {
  before {
    uf = new QuickUnionUF(10)
  }
}

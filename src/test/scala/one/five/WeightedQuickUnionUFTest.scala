package one.five

import org.scalatest.FunSuite

class WeightedQuickUnionUFTest extends UFTest {
  before {
    uf = new WeightedQuickUnionUF(10)
  }
}

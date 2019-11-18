package one.five

import org.scalatest.FunSuite

class WeightenedQuickUnionByHeightUFTest extends UFTest {
  before {
    uf = new WeightenedQuickUnionByHeightUF(10)
  }
}

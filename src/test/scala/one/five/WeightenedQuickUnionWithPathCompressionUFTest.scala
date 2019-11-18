package one.five

import org.scalatest.FunSuite

class WeightenedQuickUnionWithPathCompressionUFTest extends UFTest {
  before {
    uf = new WeightenedQuickUnionWithPathCompressionUF(10)
  }
}

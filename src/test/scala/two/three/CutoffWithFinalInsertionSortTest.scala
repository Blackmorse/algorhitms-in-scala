package scala.two.three

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class CutoffWithFinalInsertionSortTest extends SortAlgorhitmTest {
  before {
    sorter = new CutoffWithFinalInsertionSort[Int](7)
  }
}

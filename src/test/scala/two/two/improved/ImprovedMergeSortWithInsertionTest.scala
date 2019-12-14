package two.two.improved

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

class ImprovedMergeSortWithInsertionTest extends SortAlgorhitmTest {
  before {
    sorter = new ImprovedMergeSortWithInsertion[Int]() with ImprovedMergerWithComparsion[Int]
  }
}

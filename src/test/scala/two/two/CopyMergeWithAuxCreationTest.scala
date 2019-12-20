package two.two

import org.scalatest.FunSuite
import two.one.SortAlgorhitmTest

import scala.reflect.ClassTag

class CopyMergeWithAuxCreationTest extends SortAlgorhitmTest {
  before {
    sorter = new CopyMergeSortWithAuxCreation[Int]()
  }
}

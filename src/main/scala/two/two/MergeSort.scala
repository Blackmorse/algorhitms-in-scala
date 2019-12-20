package two.two

import two.one.SortAlgorhitm

import scala.reflect.ClassTag

abstract class MergeSort[T: ClassTag] extends SortAlgorhitm[T] with Merger[T] {
}

package sort

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll

import scala.math.Ordering.fromLessThan

class MergeSortTest extends Properties("MergeSort sorts a list") {

    property("of type Int") = forAll { (l1: List[Int], l2: List[Int]) =>
        implicit val incr: (Int, Int) => Boolean = (a, b) => if (a < b) true else false
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

    property("of type Double") = forAll { (l1: List[Double], l2: List[Double]) =>
        implicit val incr: (Double, Double) => Boolean = (a, b) => if (a < b) true else false
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

}

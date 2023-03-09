package sort

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.funsuite.AnyFunSuite


class MergeSortTest extends Properties("MergeSort sorts a list") {

    import scala.math.Ordering.Implicits._

    property("of type Int increasing order") = forAll { (l1: List[Int], l2: List[Int]) =>
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

    property("of type Int decreasing order") = forAll { (l1: List[Int], l2: List[Int]) =>
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

    property("of type Double") = forAll { (l1: List[Double], l2: List[Double]) =>
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

}


class MergeSortManualTest extends AnyFunSuite {
    
    val unordered = List(5, 2, 4, 6, 3, 1)
    val sortedIncr = List(1, 2, 3, 4, 5, 6)
    val sortedDecr = List(6, 5, 4, 3, 2, 1)

    test("Apply MergeSort with increasning order") {
        assert(MergeSort(unordered) == sortedIncr)
    }

    test("Apply MergeSort with decreasning order") {
        implicit val reverse = Ordering.fromLessThan[Int](_ > _)
        assert(MergeSort(unordered) == sortedDecr)
    }

}
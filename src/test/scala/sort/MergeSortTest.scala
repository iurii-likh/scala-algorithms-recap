package sort

import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import org.scalatest.funsuite.AnyFunSuite


class MergeSortTest extends Properties("MergeSort sorts a list") {

    property("of type Int increasing order") = forAll { (l1: List[Int], l2: List[Int]) =>
        implicit val incr: (Int, Int) => Boolean = (a, b) => if (a < b) true else false
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

    property("of type Int decreasing order") = forAll { (l1: List[Int], l2: List[Int]) =>
        implicit val incr: (Int, Int) => Boolean = (a, b) => if (a < b) false else true
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

    property("of type Double") = forAll { (l1: List[Double], l2: List[Double]) =>
        implicit val incr: (Double, Double) => Boolean = (a, b) => if (a < b) true else false
        MergeSort(l1 ++ l2) == MergeSort(l2 ++ l1)
    }

}


class MergeSortManualTest extends AnyFunSuite {

    test("Apply MergeSort with increasning order") {
        implicit val incr: (Int, Int) => Boolean = (a, b) => if (a < b) true else false
        val unordered = List(5, 2, 4, 6, 3, 1)
        assert(MergeSort(unordered) == List(1, 2, 3, 4, 5, 6))
    }

    test("Apply MergeSort with decreasning order") {
        implicit val incr: (Int, Int) => Boolean = (a, b) => if (a > b) true else false
        val unordered = List(5, 2, 4, 6, 3, 1)
        assert(MergeSort(unordered) == List(1, 2, 3, 4, 5, 6).reverse)
    }

}
package sort

import scala.annotation.tailrec

import sort.Algorithm


object MergeSort extends Algorithm {

    override def apply[T](xs: List[T])(implicit comp: (T, T) => Boolean): List[T] = {

        @tailrec
            def merge[T](left: List[T], right: List[T], acc: List[T] = Nil)
                        (comp: (T, T) => Boolean): List[T] =
                (left, right) match {
                    case (Nil, Nil) | (Nil, _) | (_, Nil) => acc ++ left ++ right
                    case (lh :: lt, rh :: rt) => 
                        if (comp(lh, rh)) merge(lt, right, acc :+ lh)(comp)
                        else              merge(left,  rt, acc :+ rh)(comp)
                }

        xs match {
            case Nil | List(_) => xs
            case _ =>
                val (left, right) = xs.splitAt(xs.size / 2)
                merge(MergeSort(left), MergeSort(right))(comp)
        }
    }

}

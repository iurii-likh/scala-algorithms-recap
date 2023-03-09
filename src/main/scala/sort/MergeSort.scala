package sort

import scala.annotation.tailrec

import sort.Algorithm


object MergeSort extends Algorithm {
    override def apply[T](xs: List[T])(implicit ordering: Ordering[T]): List[T] = {
        
        @tailrec
        def merge(left: List[T], right: List[T], acc: List[T] = Nil): List[T] =
            (left, right) match {
                case (Nil, Nil) | (Nil, _) | (_, Nil) => acc ++ left ++ right
                case (lh :: lt, rh :: rt) =>
                    if (ordering.lt(lh, rh)) merge(lt, right, acc :+ lh)
                    else                     merge(left,  rt, acc :+ rh)
            }

        xs match {
            case Nil | List(_) => xs
            case _ =>
                val (left, right) = xs.splitAt(xs.size / 2)
                merge(MergeSort(left), MergeSort(right))
        }
    }

}

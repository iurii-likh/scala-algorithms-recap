package sort

trait Algorithm {
  type T
  def apply[T](xs: List[T])(implicit ordering: Ordering[T]): List[T]
}

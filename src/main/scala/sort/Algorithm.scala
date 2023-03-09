package sort

trait Algorithm {
  def apply[T](xs: List[T])(implicit ordering: Ordering[T]): List[T]
}

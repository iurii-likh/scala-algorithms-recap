package sort

trait Algorithm {
  type T
  def apply[T](xs: List[T])(implicit comp: (T, T) => Boolean): List[T]
}

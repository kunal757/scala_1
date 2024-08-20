object Q24 {
  def main(args: Array[String]): Unit = {
    val digits = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nthPermutation = digits.permutations.drop(999999).next() // Zero-based index
    println(s"The millionth lexicographic permutation of the digits 0 to 9 is ${nthPermutation.mkString}")
  }
}

object Q24 {
  def factorial(n: Int): Int = {
    def factAcc(acc: Int, n: Int): Int = {
      if (n <= 1) acc
      else factAcc(acc * n, n - 1)
    }
    factAcc(1, n)
  }
  def findNthPermutation(digits: List[Int], n: Int): List[Int] = {
    def findPermutation(remainingDigits: List[Int], n: Int, acc: List[Int]): List[Int] = {
      if (remainingDigits.isEmpty) acc
      else {
        val permCount = factorial(remainingDigits.length - 1)
        val selectedIndex = (n - 1) / permCount
        val selectedDigit = remainingDigits(selectedIndex)
        findPermutation(remainingDigits.patch(selectedIndex, Nil, 1), n - selectedIndex * permCount, acc :+ selectedDigit)
      }
    }
    findPermutation(digits, n, List())
  }

  def main(args: Array[String]): Unit = {
    val digits = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    val nthPermutation = findNthPermutation(digits, 1000000)
    println(s"The millionth lexicographic permutation of the digits 0 to 9 is ${nthPermutation.mkString}")
  }
}


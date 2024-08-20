object SpiralDiagonalSum {
  def diagonalSum(size: Int): Int = {
    require(size % 2 == 1, "Size must be an odd number.")

    // Recursive function to calculate the sum of diagonals
    def calculateSum(currentSize: Int, currentNumber: Int, acc: Int): Int = {
      if (currentSize > size) acc
      else {
        val layerIncrement = currentSize - 1
        val layerSum = (1 to 4).map(i => currentNumber + layerIncrement * i).sum
        calculateSum(currentSize + 2, currentNumber + layerIncrement * 4, acc + layerSum)
      }
    }

    calculateSum(3, 1, 1) // Start from layer 3 with initial sum of 1
  }

  def main(args: Array[String]): Unit = {
    val size = 1001
    val sumOfDiagonals = diagonalSum(size)
    println(s"The sum of the numbers on the diagonals in a $size by $size spiral is $sumOfDiagonals")
  }
}

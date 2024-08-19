object SpiralDiagonalSum {
  def diagonalSum(size: Int): Int = {
    require(size % 2 == 1, "Size must be an odd number.")

    var sum = 1 // Starting with the center of the spiral
    var currentNumber = 1

    for (layer <- 3 to size by 2) {
      val layerIncrement = layer - 1
      for (_ <- 1 to 4) {
        currentNumber += layerIncrement
        sum += currentNumber
      }
    }

    sum
  }

  def main(args: Array[String]): Unit = {
    val size = 1001
    val sumOfDiagonals = diagonalSum(size)
    println(s"The sum of the numbers on the diagonals in a $size by $size spiral is $sumOfDiagonals")
  }
}


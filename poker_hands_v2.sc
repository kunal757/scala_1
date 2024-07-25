object Poker {
  import scala.io.Source

  sealed trait Suit
  case object Spades extends Suit
  case object Hearts extends Suit
  case object Diamonds extends Suit
  case object Clubs extends Suit

  object Suit {
    def fromChar(c: Char): Suit = c match {
      case 'S' => Spades
      case 'H' => Hearts
      case 'D' => Diamonds
      case 'C' => Clubs
      case _ => throw new IllegalArgumentException(s"Invalid suit: $c")
    }
  }

  case class Card(value: Int, suit: Suit)

  object Card {
    def fromString(s: String): Card = {
      assert(s.length == 2, "Card string should be of length 2")
      val valueChar = s.charAt(0)
      val suitChar = s.charAt(1)
      val value = valueChar match {
        case '2' => 2
        case '3' => 3
        case '4' => 4
        case '5' => 5
        case '6' => 6
        case '7' => 7
        case '8' => 8
        case '9' => 9
        case 'T' => 10
        case 'J' => 11
        case 'Q' => 12
        case 'K' => 13
        case 'A' => 14
        case _ => throw new IllegalArgumentException(s"Invalid card value: $valueChar")
      }
      val suit = Suit.fromChar(suitChar)
      Card(value, suit)
    }
  }

  case class Hand(cards: Seq[Card]) {
    assert(cards.length == 5, "Hand must contain exactly 5 cards")

    private val values = cards.map(_.value).sorted.reverse.toList
    private val suits = cards.map(_.suit).distinct
    val straights=List(14,13,12,11,10,9,8,7,6,5,4,3,2)
    val isFlush: Boolean = suits.size == 1
    val isStraight: Boolean = (values==List(14,5,4,3,2)) || (straights.sliding(5).contains(values) && values.distinct.length == 5)

    val rank: (Int, List[Int], List[Int]) = {
      val valueCounts = values.groupBy(identity).view.mapValues(_.size).toList.sortBy(-_._2)
      val score = valueCounts.map { case (v, c) => (c, v) }.sorted.reverse.unzip
      var rank = valueCounts.map(_._2) match {
        case List(1, 1, 1, 1, 1) => 0
        case List(2, 1, 1, 1) => 1
        case List(2, 2, 1) => 2
        case List(3, 1, 1) => 3
        case List(3, 2) => 6
        case List(4, 1) => 7
        case _ => -1
      }
      if(isStraight) rank=4
      if (isFlush) rank = if (isStraight) 8 else 5 //flush and straight flush
      if (isStraight && values.contains(14)&&values.contains(13)) rank = if (rank == 8) 9 else 4
      (rank, score._1, score._2)
    }
  }

  //object Hand {
  //  implicit val handOrdering: Ordering[Hand] = Ordering.by(_.rank)
  //}

  def compareHands(hand1: Hand, hand2: Hand): Int = {
    val rankComparison = hand1.rank._1.compareTo(hand2.rank._1)
    if (rankComparison != 0) {
      rankComparison
    } else {
      val scoreComparison = hand1.rank._3.zip(hand2.rank._3).collectFirst {
        case (v1, v2) if v1 > v2 => 1
        case (v1, v2) if v1 < v2 => -1
      }
      scoreComparison.getOrElse(0)
    }
  }

  def main(args: Array[String]): Unit = {
    if (args.length > 0) {
      val hands = Source.fromFile(args(0)).getLines().map(_.split(" ").toList).toList
      val results = hands.take(1000).map { handStrings =>
        val hand1 = Hand(handStrings.take(5).map(Card.fromString))
        val hand2 = Hand(handStrings.drop(5).map(Card.fromString))
        compareHands(hand1, hand2)
      }
      println(results.map {
        case 1 => 1
        case -1 => 0
        case _ => 0
      }.sum)
    } else {
      Console.err.println("Please enter filename")
    }
  }
}

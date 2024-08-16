object poker{
    import scala.io.Source
    import scala.collection.mutable._
    val values = Map('2' -> 2, '3' -> 3, '4' -> 4, '5' -> 5, '6' -> 6, '7' -> 7,
                 '8' -> 8, '9' -> 9, 'T' -> 10, 'J' -> 11, 'Q' -> 12, 'K' -> 13, 'A' -> 14)
    val straights = (for {v <- (14 to 6 by -1)} yield List(v, v-1, v-2, v-3, v-4)).toList :+ List(14, 5, 4, 3, 2)

    val ranks = List(List(1, 1, 1, 1, 1), List(2, 1, 1, 1), List(2, 2, 1), List(3, 1, 1),
                 List(), List(), List(3, 2), List(4, 1))

    def handRank(hand: List[String]): (Int, List[Int],List[Int]) = {
        val counts = hand.groupBy(_.charAt(0)).view.mapValues(_.length).toList.sortBy(-_._2)
        val score = counts.map { case (k, v) => (v, values(k)) }.toList.sorted.reverse.unzip
        val handValues = hand.map(card => values(card.charAt(0)))
        var rank = ranks.indexWhere(_ == score._1)
        if (hand.map(_.charAt(1)).toSet.size == 1) rank = 5 // flush
        if (straights.contains(handValues.sorted.reverse.take(5))) rank = if (rank == 5) 8 else 4 // straight or straight flush
        if (score._2.head== 14) rank= if(rank==8) 9 else rank
        (rank, score._1,score._2)
    }
    def comparer(s1:(Int, List[Int],List[Int]),s2:(Int, List[Int],List[Int])):Int={
        if(s1._1>s2._1){
            1
        }
        else if(s1._1==s2._1){
            val ab=s1._3.zip(s2._3)
            for(k<-ab){
                if(k._1>k._2){
                    return 1
                }
                else if(k._1<k._2){
                    return 0
                }
            }
            -1
        }
        else{
            0
        }
    }
    def main(args:Array[String]):Unit={
        if (args.length > 0) {
            val hands = Source.fromFile(args(0)).getLines().map(_.split(" ").toList).toList
            val a=hands.take(1000).map(hand=> (handRank(hand.take(5)),handRank(hand.drop(5)))).toList
           // println(a)
            println(a.map(b=> (comparer(b._1,b._2))).reduce(_+_))
            }
        else
            Console.err.println("Please enter filename")    
    }
}
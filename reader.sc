import scala.io.Source
import scala.collection.mutable._
//import scala.collection.immutable._
object reader{
    def main(args: Array[String]):Unit={
        if (args.length > 0) {
            println("flag")
            for (line <- Source.fromFile(args(0)).getLines())
                println(line)
            }
        else
            Console.err.println("Please enter filename")
        val states=Map(1->"AMD",2->"CMD",3->"MDMA")
        println(states.apply(1))
        states(1)="Kunal"
        println(states(1))
        //Creating a sorted set Or Treeset with ordering, Ordering is optional
        val order=Ordering.fromLessThan[String](_>_)
        var tree=TreeSet.empty(order)
        tree+="one"+="two"+="three"+="four"+="Pratik"
        println(tree)
        tree-="one"
        println(tree)
        var seq:Seq[Int]=Array(5,3,2,1)
        println(seq)
        seq=seq.reverse
        println(seq)
    }    
}
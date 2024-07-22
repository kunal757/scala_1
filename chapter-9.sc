object curry{
    def first(x: Int) = (y: Int) => x + y
    def main(args:Array[String]):Unit={
        val second= first(5)
        println(second(2))
    }
}
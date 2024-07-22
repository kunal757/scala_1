trait walker{
    def walk(x:Int,y:Int): Int
    def rest(): Unit={
        Thread.sleep(2000)
    }
    def run(): Unit={
        println("Running")
    }
}
class Dog extends walker{
    def walk(x:Int,y:Int): Int = (x+y)
    def apply():Unit={
        rest();
        run();
    }
}
//object Dog {
//def main(args:Array[String]):Unit={
//        walk(1,2)
//
//    }
//}  This companion object doesn't share the scope of methods of Dog class. Need to create a class for that
object creator{
    def main(args:Array[String]):Unit={
        println("Executor")
        val cookie=new Dog()
        cookie.apply() // Need to explicitly call the method as in creator class apply function is not automatically executed.
        println(cookie)
    }
}
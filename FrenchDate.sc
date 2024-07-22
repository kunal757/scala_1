import java.time.format.{DateTimeFormatter, FormatStyle}
import java.time.LocalDate
import java.util.Locale._

object FrenchDate {
  val t1=System.nanoTime()
  def main(args: Array[String]): Unit = {
    val now = LocalDate.now
    val df = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).withLocale(FRANCE)
    println(df.format(now))
    val duration=(System.nanoTime()-t1)/1e9d
    println(duration)
  }
}

//to show that the packages from Java can be directky imported into the system.
//Tester
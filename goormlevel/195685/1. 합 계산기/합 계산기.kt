import java.util.*
import java.io.*
import java.lang.Character.isDigit

fun main(args: Array<String>) {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var result = 0

    repeat(br.readLine().toInt()) {
        val calc = br.readLine().split(" ").map { it }
         if (calc[1] == "*"){
         	result += calc[0].toInt() * calc[2].toInt()
         } else if (calc[1] == "/") {
             result += calc[0].toInt() / calc[2].toInt()
         } else if (calc[1] == "+") {
             result += calc[0].toInt() + calc[2].toInt()
         } else {
             result += calc[0].toInt() - calc[2].toInt()
         }
    }
    println(result)
    br.close()

}


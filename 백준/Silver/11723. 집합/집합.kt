import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    var bit = 0
    val sb = StringBuilder()

    repeat(n) {
        val input = br.readLine().split(" ")
        var num = 0
        if (input[0] != "all" && input[0] != "empty")
            num = input[1].toInt()

        when (input[0]) {
            "add" -> {
                bit = bit or (1 shl num - 1)
            }
            "remove" -> {
                bit = bit and (1 shl num - 1).inv()
            }
            "check" -> {
                val temp: Int = bit and (1 shl num - 1)
                sb.append(if (temp != 0) "1" else "0").append("\n")
            }
            "toggle" -> {
                bit = bit xor (1 shl num - 1)
            }
            "all" -> bit = bit or 0.inv()
            "empty" -> bit = 0
        }
    }
    println(sb.toString())
}
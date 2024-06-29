import java.util.Scanner
import kotlin.math.*
fun main(args: Array<String>) {
	val N = readLine()?.toInt()
	// [ D , P ]
	val result = arrayOf(0,0)

	for (i in 1..N!!) {
			val predict = readLine()
			if (predict == "D") {
					result[0] += 1
			} else {
					result[1] += 1
			}
			if (abs(result[0]-result[1]) >= 2){
				break
			}
	}
	print("${result[0]}:${result[1]}")
}
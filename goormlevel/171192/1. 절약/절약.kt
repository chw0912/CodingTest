import java.util.Scanner
fun main(args: Array<String>) {
	val N = readLine()!!.toInt()
	var revenue: Long = 0L
	
	for (i in 1..N) {
		val (c,v) = readLine()!!.split(" ").map { it }
		
		if (c == "in") {
			revenue += v.toLong()
		} else {
			revenue -= v.toLong()
		}
		
		if (revenue < 0L) {
			println("fail")
			return
		}
	}
	println("success")
	return 
	
}
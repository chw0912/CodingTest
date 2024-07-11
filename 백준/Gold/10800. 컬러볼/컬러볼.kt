package gold

import java.io.BufferedReader
import java.io.InputStreamReader

data class Ball(val idx: Int, val color: Int, val size: Int)

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val N = br.readLine().toInt()

    val balls = mutableListOf<Ball>()
    val result = Array(N) { 0 }

    for (i in 0 until N) {
        val (color, size) = br.readLine().split(" ").map { it.toInt() }
        balls.add(Ball(i, color, size))
    }
    balls.sortBy { it.size }

    val colorSums = IntArray(N+1)
    var totalSum = 0
    var j = 0

    for (i in 0 until N) {
        val ball = balls[i]

        while (j < i && balls[j].size < ball.size) {
            totalSum += balls[j].size
            colorSums[balls[j].color] += balls[j].size
            j++
        }
        result[ball.idx] = totalSum - colorSums[ball.color]

    }

    result.forEach { println(it)
    }
}
import java.util.Scanner
import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.arrayOf as arrayOf


// 동, 서, 남, 북
val dx = arrayOf(0, 0, 1, -1)
val dy = arrayOf(1, -1, 0, 0)

fun main(args: Array<String>) {
    val (N,K) = readLine()!!.split(" ").map { it.toInt() }

    val area = makeArea(N)
    val bombArea = makeBomb(N)
    val bombPosition = makebombPosition(K)

    for (i in bombPosition.indices) {
        bombDrop(bombPosition[i],bombArea,area)
    }

    val maxResult = area.flatten().maxOrNull() ?: 0
    println(maxResult)
}


fun makeArea(n: Int): Array<Array<Int>> {
    val area = Array(n, { Array(n, { 0 }) })

    return area
}

fun makeBomb(n: Int): Array<Array<String>> {
    val bombPo = Array(n, { Array(n, { "" }) })
    for (i in 0..n-1) {
        bombPo[i] = readLine()!!.split(" ").map { it }.toTypedArray()
    }
    return bombPo
}

fun makebombPosition (k: Int): Array<Array<Int>> {
    val positions = Array(k, { Array(2, { 0 }) })

    for (i in positions.indices) {
        val (x,y) = readLine()!!.split(" ").map { it.toInt() }
        positions[i][0] = x-1
        positions[i][1] = y-1
    }
    return positions
}

fun bombDrop(position: Array<Int>, bombArea: Array<Array<String>>, area: Array<Array<Int>>) {
    val (x,y) = position.map { it }

    if (bombArea[x][y].toIntOrNull() != null) {
        area[x][y] += 1
    } else if (bombArea[x][y] == "@") {
        area[x][y] += 2
    }

    for (i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]
        if (nx in 0..area.size-1  && ny in 0..area.size-1) {
            if (bombArea[nx][ny].toIntOrNull() != null) {
                area[nx][ny] += 1
            } else if (bombArea[nx][ny] == "@") {
                area[nx][ny] += 2
            }
        }

    }

}
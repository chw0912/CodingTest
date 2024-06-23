class Solution {
    fun solution(n: Int): IntArray {
        var num = n
        val answer = mutableListOf<Int>(num)
        while (num != 1) {
            if (num % 2 == 0) num /= 2
            else num = 3 * num + 1
            answer.add(num)
        }
        return answer.toIntArray()
    }
}
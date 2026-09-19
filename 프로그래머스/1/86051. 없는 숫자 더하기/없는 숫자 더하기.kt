class Solution {
    // 코틀린
    fun solution(numbers: IntArray): Int {
        var answer = 0
        for (i in 1..9) {
            if (numbers.contains(i) == false) answer+= i
        }
        return answer
    }
}
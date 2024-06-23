class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        var answer: IntArray = intArrayOf()
        
        for (i in start_num downTo end_num) {
            answer += i
        }
        return answer
    }
}
class Solution {
    fun solution(start_num: Int, end_num: Int): IntArray {
        var answer = ArrayList<Int>()
        
        for (i in start_num downTo end_num) {
            answer.add(i)
        }
        
        return answer.toIntArray()
    }
}
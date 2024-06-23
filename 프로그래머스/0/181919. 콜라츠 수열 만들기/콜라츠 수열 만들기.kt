class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var num: Int = n
        
        while (num > 1) {
            answer += num
            
            if (num % 2 == 0) {
                num /= 2
            } else {
                num = (num * 3) + 1
            }
        }
        answer += num
        
        return answer
    }
}
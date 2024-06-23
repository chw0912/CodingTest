class Solution {
    fun solution(n: Int): IntArray {
        var answer = ArrayList<Int>()
        answer.add(n)
        var num: Int = n
        
        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2
            } else {
                num = (num * 3) + 1
            }
            answer.add(num)
        }
        
        return answer.toIntArray()
    }
}
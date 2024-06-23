class Solution {
    fun solution(x: Int, n: Int): LongArray {
        var answer = LongArray(n)
        
        for (i in 1..n) answer[i-1] = (x.toLong() * i)
        
        return answer
    }
}
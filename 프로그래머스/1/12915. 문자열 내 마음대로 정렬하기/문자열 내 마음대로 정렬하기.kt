class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = strings
        
        var list = answer.sortedWith(compareBy({ it[n] }, { it }))
        return list.toTypedArray()
    }
}
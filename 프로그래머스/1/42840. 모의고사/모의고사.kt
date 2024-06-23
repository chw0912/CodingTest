import java.util.*
class Solution {
    fun solution(answers: IntArray): IntArray {
        val score = IntArray(3)
        
        val student1 = listOf(1,2,3,4,5)
        val student2 = listOf(2,1,2,3,2,4,2,5)
        val student3 = listOf(3,3,1,1,2,2,4,4,5,5)
        

        
        for (i in answers.indices) {
            if(answers[i] == student1[i % student1.size]) score[0] ++
            if(answers[i] == student2[i % student2.size]) score[1] ++
            if(answers[i] == student3[i % student3.size]) score[2] ++
        }
        
        val max = score[0].coerceAtLeast(score[1].coerceAtLeast(score[2]))
        val list: MutableList<Int> = ArrayList()
        
        if (max == score[0]) {
            list.add(1)
        }
        if (max == score[1]) {
            list.add(2)
        }
        if (max == score[2]) {
            list.add(3)
        }
        val answer = IntArray(list.size)
        for (i in list.indices) {
            answer[i] = list[i]
        }
        
        return answer
    }
}
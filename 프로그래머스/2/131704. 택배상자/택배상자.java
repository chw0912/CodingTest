import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        int[] index = new int[order.length];
        // 스택
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i<order.length;i++) {
            index[order[i]-1] = i;
        }
        
        for (int i = 0; i<order.length;i++) {
            if (index[i] == answer) {
                answer++;
            } else {
                stack.push(index[i]);
            }
            
            while (!stack.isEmpty() && stack.peek() == answer) {
                stack.pop();
                answer++;
            }
        }
        
        return answer;
    }
}
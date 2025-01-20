import java.util.*;

class Solution
{
    public int solution(String s)
    {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        
        for (int i =0;i<charArray.length;i++) {
            char c = charArray[i];
            
            if (stack.isEmpty())  {
                stack.push(charArray[i]);
            } else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }    
            }
        }
        int answer = stack.isEmpty() ? 1 : 0;
        
        return answer;
    }
    
    
}
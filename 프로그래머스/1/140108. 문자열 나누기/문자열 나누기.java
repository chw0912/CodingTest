import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        char[] str = s.toCharArray();
        List<String> strList = new ArrayList<>();
        char first = str[0];
        int same = 0;
        int diff = 0;
        
        for (int i=0;i<str.length;i++) {
            if (first == str[i]) {
                same ++;
            } else if(first != str[i]) {
                diff ++;
            }
            
            if (same == diff) {
                same = 0;
                diff = 0;
                answer ++;
                if (i+1 < str.length) {
                    first = str[i+1];
                }
            }
            
            if (same != diff && i == str.length-1) {
                answer ++;
            }
        }
        
        return answer;
    }
}
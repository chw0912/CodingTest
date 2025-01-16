import java.util.Arrays;

class Solution {
    public String solution(String s) {
        char[] chArray = s.toCharArray();
        Arrays.sort(chArray);
        
        String str = new String(chArray);
        String result = new StringBuilder(str).reverse().toString();
        
        return result;
    }
}
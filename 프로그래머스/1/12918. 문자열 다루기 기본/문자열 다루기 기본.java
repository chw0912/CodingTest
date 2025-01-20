class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        for (int i =0; i < s.length();i++) {
            if ((len == 4 || len == 6) && Character.isDigit(s.charAt(i))) {
                answer = true;
            } else {
                answer = false;
                break;
            }
        }
    
        return answer;
    }
}
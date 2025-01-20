class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split("");
        int key = 0;
        
        for (String tmp : str) {
            key = tmp.contains(" ") ? 0 : key + 1;
            answer += key % 2 == 0 ? tmp.toLowerCase() : tmp.toUpperCase();
        }
        
        return answer;
    }
}
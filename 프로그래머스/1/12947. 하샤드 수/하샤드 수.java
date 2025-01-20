class Solution {
    public Boolean solution(int x) {
        int result = 0;
        String[] num = String.valueOf(x).split("");
        
        for (String s: num) {
            result += Integer.parseInt(s);
        }
        if (x % result == 0) {
            return true;
        }
        
        return false;
    }
}
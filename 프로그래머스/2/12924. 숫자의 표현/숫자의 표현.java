class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n;i++) {
            int x = 0;
            for (int j = i;j <= n;j++) {
                x += j;
                if (x == n) {
                    answer++;
                    break;
                } else if (x > n) {
                    break;
                }
            }
        }
        
        return answer;
    }
}
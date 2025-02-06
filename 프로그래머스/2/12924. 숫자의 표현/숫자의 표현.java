class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i< n+1;i++) {
            int x = i;
            for (int j = i + 1;j < n + 1;j++) {
                x += j;
                if (x == n) {
                    answer++;
                    break;
                } else if (x > n) {
                    break;
                }
            }
        }
        answer++;
        
        return answer;
    }
}
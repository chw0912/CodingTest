class Solution {
    public int[] solution(int n, int m) {
        int maxNum = 0;
        int[] result = new int[2];
        
        // 최대 공약수
        for (int i = 1; i <= n && i <= m; i++) {
            if (n % i == 0 && m % i == 0) {
                maxNum = i;
            }
        }
        result[0] = maxNum;
        result[1] = (n * m) / maxNum;
        return result;
    }
}
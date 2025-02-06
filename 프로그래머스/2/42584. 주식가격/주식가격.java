class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for (int i = 0;i < answer.length; i++) {
            answer[i] = 0;
            for (int j = i + 1; j<answer.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                } else {
                    answer[i]++;
                }
            }
        }
        
        return answer;
    }
}
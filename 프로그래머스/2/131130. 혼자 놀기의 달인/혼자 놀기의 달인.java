class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        
        // 방문처리
        boolean[] visited = new boolean[cards.length];
        
        int group1 = 0;
        int group2 = 0;
        
        for (int i = 0; i < cards.length; i++) {
            int cnt = 0; 
            int idx = i;
            while (!visited[idx]) {
                visited[idx] = true;
                idx = cards[idx]-1;
                cnt++;
            }

            if (group1 == cards.length) {
                group1 = 0;
                break;
            }
            
            
            if (group1 < Math.max(group1, cnt)) {               
                group2 = group1;
                group1 = cnt;
                
            } else if (group2 < Math.max(group2, cnt)) {
                group2 = cnt;
            }
        }
        answer = group1 * group2;
        
        return answer;
    }
}
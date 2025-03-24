class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for (int i = 0; i <schedules.length; i++)  {
            int eventTime = timePlusTen(schedules[i]);
            boolean status = true;
            int start = startday;
            
            for (int j = 0; j < 7; j++) {
                
                if (start == 6) {
                    start++;
                    continue;
                } else if (start == 7) {
                    start = 1;
                    continue;
                } else {
                    start++;
                }
                
                if (timelogs[i][j] > eventTime) {
                    status = false;
                    break;
                }
                
            }
            if (status) {
                answer++;
            }
            
        }
        
        return answer;
    }
    
    public int timePlusTen(int time) {
        int plusTime = (time + 10) % 100;
        if (plusTime >= 60) {
            return time + 50;
        } else {
            return time + 10;
        }
    }
}
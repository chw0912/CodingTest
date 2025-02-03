import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Map<Integer,Integer> students = new HashMap<>();
        boolean[] visited = new boolean[n];
        
        for (int i = 1; i < n + 1; i++) {
            students.put(i,1);
        }
        
        for (int i = 0; i<lost.length;i++) {
            int key = lost[i];
            visited[key-1] = false;
            students.replace(key,students.get(key)-1);
        }
        
        for (int i = 0; i<reserve.length;i++) {
            int key = reserve[i];
            visited[key-1] = true;
            students.replace(key,students.get(key)+1);
        }
        
        for (int i = 1; i < n+1;i++) {
            if (students.get(i) != 0) {
                answer += 1;
                if (students.get(i) == 2) {
                    if (students.containsKey(i-1) && students.get(i-1) == 0 && visited[i-2] == false) {
                        answer += 1;
                        visited[i-2] = true;
                    } else if (students.containsKey(i+1) && students.get(i+1) == 0 && visited[i] == false) {
                        answer += 1;
                        visited[i] = true;
                    }
                }
            }
        }
        return answer;
    }
        
}

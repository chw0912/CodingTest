import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int index; // 다음 값들을 확인할 때 사용
        int move = length - 1; // 좌우 움직일 수 체크
        
        for (int i = 0; i< length; i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            index = i + 1;
            // 연속되는 A 갯수 확인
            while(index < length && name.charAt(index) == 'A') {
                index++;
            }
            
            // 순서대로 가는 것과, 뒤로 돌아가는 것 중 작은 값을 선택
            move = Math.min(move, i * 2 + length - index);
            
            move = Math.min(move, (length-index) * 2 + i);
            
        }
        
        
        return answer + move;
    }
}
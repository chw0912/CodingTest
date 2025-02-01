import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        char[] dart = dartResult.toCharArray();
        int[] score = new int[3];
        
        int idx = -1;
        
        for (int i = 0;i < dart.length;i++) {
            if (dart[i] == '1' && dart[i+1] == '0') {
                idx++;
                score[idx] = 10;
                i++;
            } else if (dart[i] >= '0' && dart[i] <= '9') {
                idx++;
                score[idx] = Integer.parseInt(Character.toString(dart[i]));  
            }
            
            switch(dart[i]) {
                case 'D':  
                    score[idx] = (int) Math.pow(score[idx], 2);
                    break;
                case 'T':
                    score[idx] = (int) Math.pow(score[idx], 3);
                    break;
                case '*':
                    score[idx] *= 2;
                    if (idx - 1 >= 0) {
                        score[idx - 1] *= 2;
                    }
                    break;
                case '#':
                    score[idx] *= -1;
            }
        }
        
        
        
        
        
        return score[0] + score[1] + score[2];
    }
}
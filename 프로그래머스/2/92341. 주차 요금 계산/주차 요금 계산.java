import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        // 차량 번호, 출입 시간
        Map<String,Integer> map = new HashMap<>();
        // 차량 번호, 
        Map<String,Integer> feeMap = new HashMap<>();
        
        int baseTime = fees[0];
        int basePrice = fees[1];
        int partTime = fees[2];
        int partPrice = fees[3];
        
        for (int i = 0;i < records.length;i++) {
            String[] record = records[i].split(" ");
            int time = getTime(record[0]);
            String carNum = record[1];
            String io = record[2];
            
            
            if (io.equals("IN")) {
                map.put(carNum, time);  
            } else {
                int inTime = map.get(carNum);
                map.remove(carNum);
                if (feeMap.containsKey(carNum)) {
                    int currentTime = feeMap.get(carNum);
                    feeMap.replace(carNum, currentTime + time - inTime);
                } else {
                        feeMap.put(carNum, time - inTime);
                }
            }
            
        }
        int lastTime = 60 * 24 - 1;
        for (String carNum : map.keySet()) {
            int inTime = map.get(carNum);
            if (feeMap.containsKey(carNum)) {
                int totalTime = feeMap.get(carNum);
                feeMap.replace(carNum, totalTime + lastTime - inTime);
            } else {
                feeMap.put(carNum, lastTime - inTime);
            }
        }
        Object[] sortKey = feeMap.keySet().toArray();
        Arrays.sort(sortKey);
        answer = new int [sortKey.length];
        
        for (int i = 0; i<answer.length;i++) {
            int result = basePrice;
            String carNum = String.valueOf(sortKey[i]);
            
            int val = feeMap.get(carNum);
            if (val > baseTime) {
                result = (int) (basePrice + Math.ceil((double)(val-baseTime)/partTime) * partPrice);
            }
            answer[i] = result;
        }
        return answer;
    }
    

    
    public int getTime(String time) {
        String[] tmp = time.split(":");
        int hour = Integer.parseInt(tmp[0]) * 60;
        int minute = Integer.parseInt(tmp[1]); 
        
        return hour + minute;
    }
}
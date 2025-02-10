class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        String str = "";
        String[] arr = s.split("");
        
        
        for (int i = 0; i< s.length(); i++) {
            if (str.contains(arr[i])) {
                int idx = str.lastIndexOf(arr[i]);
                answer[i] = i - idx;
                str += arr[i];
            } else {
                answer[i] = -1;
                str += arr[i];
            }
        }
        return answer;
    }
}
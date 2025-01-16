import java.util.HashSet;
import java.util.Set;
class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<Integer>();
       
        for (int num : nums) {
            set.add(num);
        }
        if (set.size() > nums.length/2) {
            answer = nums.length/2;
        } else {
            answer = set.size();
        }
        
        
        return answer;
    }
}
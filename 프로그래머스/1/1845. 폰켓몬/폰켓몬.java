import java.util.*;

class Solution {
    public int solution(int[] nums) {        
        int N = nums.length;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        
        int size = map.size();
        if (size >= (N / 2)) {
            return N / 2;
        }
        
        return size;
    }
}
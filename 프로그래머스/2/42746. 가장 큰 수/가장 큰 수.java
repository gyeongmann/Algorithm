import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int l = numbers.length;
        String[] nums = new String[l];
        for (int i = 0; i < l; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(nums, (a, b) -> {
            int ab = Integer.parseInt(a + b);
            int ba = Integer.parseInt(b + a);
            return Integer.compare(ba, ab);
        });
        
        for (String n : nums) {
            answer += n;
        }
        
        if (answer.startsWith("0")) {
            answer = "0";
        }
        return answer;
    }
}
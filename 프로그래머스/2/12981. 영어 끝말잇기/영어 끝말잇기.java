import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int l = words.length;
        
        Set<String> memo = new HashSet<>();
        for (int i = 1; i < l; i++) {
            String prev = words[i-1];
            char prevLast = prev.charAt(prev.length()-1);
            memo.add(prev);
            
            String curr = words[i];
            char currFirst = curr.charAt(0);
            if (prevLast != currFirst || memo.contains(curr)) {
                int remain = i % n;
                int quot = i / n;
                answer[0] = remain + 1;
                answer[1] = quot + 1;
                break;
            }
        }

        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int wanhoA = scores[0][0];
        int wanhoB = scores[0][1];
        int wanhoSum = wanhoA + wanhoB;
        
        Arrays.sort(scores, (a, b) -> {
            if (a[0] == b[0]) return Integer.compare(a[1], b[1]);
            return Integer.compare(b[0], a[0]);
        });
        
        int maxB = 0;
        int rank = 1;
        for (int[] s : scores) {
            int a = s[0], b = s[1];
            
            if (b < maxB) {
                if (a == wanhoA && b == wanhoB) return -1;
                continue;
            }
            
            if (a + b > wanhoSum) answer++;
            
            maxB = Math.max(maxB, b);
        }
        return answer;
    }
}
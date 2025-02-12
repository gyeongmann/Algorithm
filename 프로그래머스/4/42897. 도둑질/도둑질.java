import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int N = money.length;
        int[] dp1 = new int[N];
        int[] dp2 = new int[N];
        
        // 1번째 o
        dp1[0] = money[0];
        dp1[1] = money[1];
        for (int i = 2; i < N-1; i++) {
            dp1[i] = Math.max(dp1[i-2] + money[i], dp1[i-1]);
            dp1[i-1] = Math.max(dp1[i-1], dp1[i-2]);
        }
        dp1[N-1] = Math.max(dp1[N-3], dp1[N-2]);
        
        // 1번째 x
        dp2[1] = money[1];
        for (int i = 2; i < N; i++) {
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
            dp2[i-1] = Math.max(dp2[i-1], dp2[i-2]);
        }
        
        answer = Math.max(dp1[N-1], dp2[N-1]);
        // System.out.println(Arrays.toString(dp1));
        // System.out.println(Arrays.toString(dp2));
        return answer;
    }
}
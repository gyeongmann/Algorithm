import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];
        for (int r = 1; r < n; r++) {
            dp[r][0] = dp[r-1][0] + triangle[r][0];
            for (int c = 1; c <= r; c++) {
                dp[r][c] = Math.max(dp[r-1][c-1], dp[r-1][c]) + triangle[r][c];
            }
        }
        
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        
        for (int c = 0; c < n; c++) {
            answer = Math.max(answer, dp[n-1][c]);
        }
        return answer;
    }
}
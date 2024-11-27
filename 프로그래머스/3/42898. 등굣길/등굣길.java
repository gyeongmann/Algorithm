import java.util.*;
class Solution {
    int mod = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        boolean[][] isPuddle = new boolean[n][m];
        for (int[] puddle : puddles) {
            isPuddle[puddle[1]-1][puddle[0]-1] = true;
        }
        
        int[][] dp = new int[n][m];
        for (int c = 0; c < m; c++) {
            if (isPuddle[0][c]) break;
            dp[0][c] = 1;
        }
        
        for (int r = 0; r < n; r++) {
            if (isPuddle[r][0]) break;
            dp[r][0] = 1;
        }
        
        for (int r = 1; r < n; r++) {
            for (int c = 1; c < m; c++) {
                if (isPuddle[r][c]) continue;
                dp[r][c] = ((dp[r-1][c]%mod) + (dp[r][c-1]%mod)) % mod;
            }
        }
        
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        answer = dp[n-1][m-1];
        return answer;
    }
}
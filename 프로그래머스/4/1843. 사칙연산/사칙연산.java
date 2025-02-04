import java.util.*;

class Solution {
    int[][][] dp;
    int[] num;
    String[] op;
    int l, n;
    
    public int solution(String arr[]) {
        l = arr.length;
        n = l/2+1;
        init(arr);
        
        for (int d = 1; d < n; d++) {
            for (int i = 0; i < n - d; i++) {
                // System.out.println(i + " " + (i+d));
                cal(i, i+d);
                // print();
            }
        }
        
        int answer = dp[0][n-1][0];
        return answer;
    }
    
    private void print() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(dp[i][j][0] + "," + dp[i][j][1] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private void init(String[] arr) {
        num = new int[n];
        op = new String[n-1];
        for (int i = 0; i < l; i++) {
            if (i % 2 == 0) {
                num[i/2] = Integer.parseInt(arr[i]);
            } else {
                op[i/2] = arr[i];
            }
        }
        
        dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = num[i];
            dp[i][i][1] = num[i];
        }
    }
    
    private void cal(int i, int j) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            String curr = op[k];
            if (curr.equals("-")) {
                max = Math.max(max, dp[i][k][0] - dp[k+1][j][1]);
                min = Math.min(min, dp[i][k][1] - dp[k+1][j][0]);
            } else {
                max = Math.max(max, dp[i][k][0] + dp[k+1][j][0]);
                min = Math.min(min, dp[i][k][1] + dp[k+1][j][1]);
            }
        }
        dp[i][j][0] = max;
        dp[i][j][1] = min;
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 2) {
            System.out.println(2);
            return;
        }

        int[][] dp = new int[n+1][n+1];
        dp[2][1] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i-1][j] * 2 + dp[i-1][j-1] + dp[i-1][j+1];
                dp[i][j] %= 10007;
            }
        }

        int answer = 0;
        for (int i = 1; i < n; i++) {
            answer += dp[n][i];
            answer %= 10007;
        }

        System.out.println(answer);
    }

}
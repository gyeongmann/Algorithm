import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        int[] dp = new int[X + 1];
        dp[1] = 0;

        for (int i = 2; i <= X; i++) {
            int best = dp[i - 1] + 1;          // 1 빼기
            if (i % 2 == 0) best = Math.min(best, dp[i / 2] + 1);
            if (i % 3 == 0) best = Math.min(best, dp[i / 3] + 1);
            dp[i] = best;
        }

        System.out.println(dp[X]);
    }
}

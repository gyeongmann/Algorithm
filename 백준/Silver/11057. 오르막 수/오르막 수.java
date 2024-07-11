import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		long[][] dp = new long[N + 1][10]; // dp[m][n] : n으로 끝나는 수의 개수
		Arrays.fill(dp[1], 1);
		for (int r = 2; r <= N; r++) {
			dp[r][0] = 1;
			for (int c = 1; c <= 9; c++) {
				dp[r][c] = (dp[r-1][c] + dp[r][c-1]) % 10_007;
			}
		}
		
		long ans = 0;
		for (int i = 0; i < 10; i++) {
			ans += dp[N][i];
		}
		System.out.println(ans % 10007);
	}
}
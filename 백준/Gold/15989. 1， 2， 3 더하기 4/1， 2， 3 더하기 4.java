import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int[][] dp = new int[10001][3];
	static int[] ans = new int[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		init();
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(ans[n]).append("\n");
		}
		System.out.print(sb);
	}

	private static void init() {
		dp[1][0] = 1;
		ans[1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		ans[2] = 2;
		dp[3][0] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		ans[3] = 3;

		for (int i = 4; i <= 10000; i++) {
			dp[i][0] = 1;
			dp[i][1] = dp[i - 2][0] + dp[i - 2][1];
			dp[i][2] = dp[i - 3][0] + dp[i - 3][1] + dp[i - 3][2];
			ans[i] = dp[i][0] + dp[i][1] + dp[i][2];
		}
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // n, k
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coins = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			coins[i] = Integer.parseInt(in.readLine());
		}

		int[] dp = new int[k + 1];
		for (int i = 1; i <= k; i++) { // 초기값
			dp[i] = INF;
		}

		for (int i = 1; i <= n; i++) {
			int coin = coins[i];
			for (int j = 1; j <= k; j++) {
				if (j >= coin) {
					dp[j] = Math.min(dp[j], dp[j - coin] + 1);
				}
			}
		}

		if (dp[k] == INF) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[k]);
	}
}

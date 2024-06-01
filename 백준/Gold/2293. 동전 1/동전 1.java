import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // n, k
		int n = Integer.parseInt(st.nextToken()); // 동전의 종류 수
		int k = Integer.parseInt(st.nextToken()); // 목표 가치
		int[] coin = new int[n];
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(in.readLine());
		}
		
		int[][] dp = new int[n][k + 1];
		dp[0][0] = 1;
		int curr = coin[0];
		for (int i = 1; i <= k; i++) {
			if (i - curr >= 0) {
				dp[0][i] = dp[0][i - curr];
			}
		}
		
		for (int i = 1; i < n; i++) {
			curr = coin[i];
			dp[i][0] = 1;
			for (int j = 1; j <= k; j++) {
				if (j - curr >= 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - curr];
				}
				else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
//		for (int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		System.out.println(dp[n - 1][k]);
	}
}

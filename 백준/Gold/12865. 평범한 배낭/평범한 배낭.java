import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken()); // 배낭 용량

		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken()); // 무게
			arr[i][1] = Integer.parseInt(st.nextToken()); // 가치
		}

		int[][] dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			int curWeight = arr[i - 1][0];
			int curValue = arr[i - 1][1];
			for (int j = 0; j <= K; j++) {
				if (curWeight <= j) {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - curWeight] + curValue);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		System.out.println(dp[N][K]);
	}
}

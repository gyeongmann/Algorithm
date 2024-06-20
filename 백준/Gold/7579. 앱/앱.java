import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()); // N, M
		int N = Integer.parseInt(st.nextToken()); // 활성화 되어 있는 앱 수
		int M = Integer.parseInt(st.nextToken()); // 필요 메모리
		
		int[] bytes = new int[N + 1];
		int[] costs = new int[N + 1];
		
		st = new StringTokenizer(in.readLine()); // N개의 메모리 용량들
		for (int i = 1; i <= N; i++) {
			bytes[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(in.readLine()); // 비활성화 비용
		int costSum = 0;
		for (int i = 1; i <= N; i++) {
			int cost = Integer.parseInt(st.nextToken());
			costs[i] = cost;
			costSum += cost;
		} // input
		
		int ans = costSum;
		int[][] dp = new int[N + 1][costSum + 1];
		for (int i = 1; i <= N; i++) {
			int curr = bytes[i];
			int cost = costs[i];
			
			for (int j = 0; j < cost; j++) {
				dp[i][j] = dp[i-1][j];
			}
			for (int j = cost; j <= costSum; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost] + curr);
				if (dp[i][j] >= M) {
					ans = Math.min(ans, j);
				}
			}
		}
		
//		for (int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] blocks;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, M, H
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		blocks = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			blocks[i] = new ArrayList<>();
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine()); // 블록 높이들
			int size = st.countTokens();
			for (int j = 0; j < size; j++) {
				blocks[i].add(Integer.parseInt(st.nextToken()));
			}
		} // input
		
		int[][] dp = new int[N + 1][H + 1];
		dp[0][0] = 1;
		for (int i = 1; i <= N; i++) {
			for (int h = 0; h <= H; h++) { // 목표 높이
				for (int curr = 0; curr <= h; curr++) {
					if (blocks[i].contains(h - curr)) {
						dp[i][h] += dp[i-1][curr];
					}
				}
				dp[i][h] += dp[i-1][h];
				dp[i][h] %= 10007;
			}
		}
		
		int ans = dp[N][H] % 10007;
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] map, dp;

	static int[] dc = { 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		int col = 0;
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			col++;
			for (int c = 0; c < col; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // input

		dp = new int[N][N];
		dp[0][0] = map[0][0];

		col = 2;
		for (int r = 1; r < N; r++) {
			dp[r][0] = map[r][0];
			dp[r][0] += dp[r-1][0];
			dp[r][col-1] = map[r][col-1];
			dp[r][col-1] += dp[r-1][col-2];
			for (int c = 1; c < col - 1; c++) {
				dp[r][c] = Math.max(dp[r - 1][c] + map[r][c], dp[r - 1][c - 1] + map[r][c]);
			}
			col++;
		}

		Arrays.sort(dp[N-1]);
		System.out.println(dp[N-1][N-1]);
	}
}

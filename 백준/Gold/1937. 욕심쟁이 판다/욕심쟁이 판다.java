import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static class Bamboo implements Comparable<Bamboo> {
		int r, c, val;

		Bamboo(int r, int c, int val) {
			this.r = r;
			this.c = c;
			this.val = val;
		}

		public int compareTo(Bamboo o) {
			return Integer.compare(this.val, o.val);
		}
	}

	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n];
		Bamboo[] bamboos = new Bamboo[n * n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				bamboos[n * i + j] = new Bamboo(i, j, map[i][j]);
			}
		}

		Arrays.sort(bamboos);

		int[][] dp = new int[n][n];
		for (int[] row : dp) {
			Arrays.fill(row, 1);
		}

		int ans = 1;
		for (Bamboo bamboo : bamboos) {
			int r = bamboo.r;
			int c = bamboo.c;
			int val = bamboo.val;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr >= 0 && nc >= 0 && nr < n && nc < n) { // 범위 내에서만
					if (map[nr][nc] > val) {
						dp[nr][nc] = Math.max(dp[nr][nc], dp[r][c] + 1);
						ans = Math.max(ans, dp[nr][nc]);
					}
				}
			}
		}

		System.out.println(ans);
	}
}
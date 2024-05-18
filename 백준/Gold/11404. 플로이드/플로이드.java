import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());
		
		int[][] d = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				d[i][j] = INF;
			}
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			d[from][to] = Math.min(d[from][to], cost);
		}
		
		// floyd
		for (int mid = 1; mid <= n; mid++) {
			for (int from = 1; from <= n; from++) {
				for (int to = 1; to <= n; to++) {
					if (d[from][to] > d[from][mid] + d[mid][to])
						d[from][to] = d[from][mid] + d[mid][to];
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF) {
					System.out.print(0 + " ");
					continue;
				}
				System.out.print(d[i][j] + " ");
			}
			System.out.println();
		}
	}
}

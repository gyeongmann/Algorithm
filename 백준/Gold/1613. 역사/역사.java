import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] d = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) continue;
				d[i][j] = INF;
			}
		}
		
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			d[from][to] = 1;
		}
		
		// floyd
		for (int mid = 1; mid <= n; mid++) {
			for (int from = 1; from <= n; from++) {
				for (int to = 1; to <= n; to++) {
					d[from][to] = Math.min(d[from][to], d[from][mid] + d[mid][to]);
				}
			}
		}
		
		int s = Integer.parseInt(in.readLine());
		for (int i = 0; i < s; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if (d[a][b] < INF) sb.append(-1).append('\n');
			else if (d[b][a] < INF) sb.append(1).append('\n');
			else sb.append(0).append('\n');
		}
		
		System.out.println(sb);
	}
}

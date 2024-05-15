import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());

		int[][] d = new int[n + 1][n + 1];
		int[][] nxt = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				d[i][j] = INF;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if (d[from][to] < INF) {
				d[from][to] = Math.min(d[from][to], cost) ;
				continue;
			}
			d[from][to] = cost;
			nxt[from][to] = to;
		}
		
		// floyd
		for (int mid = 1; mid <= n; mid++) {
			for (int from = 1; from <= n; from++) {
				for (int to = 1; to <= n; to++) {
					int transfer = d[from][mid] + d[mid][to];
					if (d[from][to] > transfer) {
						nxt[from][to] = nxt[from][mid];
						d[from][to] = transfer;
					}
				}
			}
		}
		
//		for (int[] row : nxt) {
//			System.out.println(Arrays.toString(row));
//		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
                if (d[i][j] == INF) {
					sb.append(0 + " ");
					continue;
				}
				sb.append(d[i][j] + " ");
			}
			sb.append('\n');
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j || d[i][j] == INF) {
					sb.append(0).append('\n');
					continue;
				}
				
				int from = i;
				int to = j;
				Queue<Integer> q = new LinkedList<>();
				q.offer(from);
				while (from != to) {
					from = nxt[from][to];
					q.offer(from);
				}
				sb.append(q.size() + " ");
				while (!q.isEmpty()) {
					sb.append(q.poll() + " ");
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}

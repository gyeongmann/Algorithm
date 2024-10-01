import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[][] adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] route = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			route[i] = Integer.parseInt(st.nextToken()) - 1;
		}

		if (M == 1) {
			System.out.println("YES");
			return;
		}

		int[][] memo = new int[N][N];
		for (int from = 0; from < N; from++) {
			Queue<Integer> q = new LinkedList<>();
			boolean[] visited = new boolean[N];
			q.add(from);
			visited[from] = true;
			memo[from][from] = 1;
			while (!q.isEmpty()) {
				int curr = q.poll();
				for (int to = 0; to < N; to++) {
					if (!visited[to] && adj[curr][to] == 1) {
						q.add(to);
						visited[to] = true;
						memo[from][to] = 1;
					}
				}
			}
		}

		for (int i = 0; i < M - 1; i++) {
			int prev = route[i];
			int next = route[i + 1];

			if (memo[prev][next] == 0) {
				System.out.println("NO");
				return;
			}
		}

		System.out.println("YES");
	}
}
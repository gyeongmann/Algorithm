import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static List<int[]>[] adj;
	static int[] d;
	static boolean[] vis;
	static int max, maxIdx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			while (true) {
				int next = Integer.parseInt(st.nextToken());
				if (next == -1) {
					break;
				}

				int cost = Integer.parseInt(st.nextToken());
				adj[idx].add(new int[] { next, cost });
			}
		}

		int s = 1;
		d = new int[N + 1];
		vis = new boolean[N + 1];
		BFS(s);

		max = 0;
		d = new int[N + 1];
		vis = new boolean[N + 1];
		BFS(maxIdx);
		System.out.println(max);
	}

	static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		vis[start] = true;
		q.offer(start);

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int[] e : adj[curr]) {
				int next = e[0];
				int cost = e[1];
				if (vis[next]) continue;
				vis[next] = true;
				q.offer(next);
				d[next] = d[curr] + cost;
				if (max < d[next]) {
					max = d[next];
					maxIdx = next;
				}
			}
		}
	}
}

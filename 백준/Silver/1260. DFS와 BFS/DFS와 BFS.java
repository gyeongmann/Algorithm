import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adj;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		adj = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			adj[v].add(c);
			adj[c].add(v);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(adj[i]);
		}

		// DFS
		vis = new boolean[N + 1];
		vis[V] = true;
		DFS(V);

		// BFS
		vis = new boolean[N + 1];
		vis[V] = true;
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(V);
		sb.append('\n');
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr + " ");
			for (int nxt : adj[curr]) {
				if (vis[nxt]) continue;
				vis[nxt] = true;
				queue.offer(nxt);
			}
		}
		System.out.println(sb.toString());
	}

	static void DFS(int curr) {
		sb.append(curr + " ");
		for (int nxt : adj[curr]) {
			if (vis[nxt]) continue;
			vis[nxt] = true;
			DFS(nxt);
		}
	}
}

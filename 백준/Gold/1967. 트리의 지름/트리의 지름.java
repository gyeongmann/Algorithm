import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int to, weight;

		public Edge(int child, int weight) {
			this.to = child;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
	}
	
	static List<Edge>[] adj;
	static boolean[] vis;
	static int max;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		adj = new ArrayList[N + 1];
		vis = new boolean[N + 1];
		for (int  i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adj[from].add(new Edge(to, weight));
			adj[to].add(new Edge(from, weight));
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(adj[i]);
//		}
		
		for (int i = 1; i <= N; i++) {
			DFS(i, 0); // 시작 위치, 누적 길이
		}
		System.out.println(max);
	}

	private static void DFS(int idx, int len) {
		if (vis[idx]) {
			return;
		}
		
		max = Math.max(len, max);
		vis[idx] = true;
		for (Edge e : adj[idx]) {
			int to = e.to;
			int weight = e.weight;
			len += weight;
			DFS(to, len);
			len -= weight;
		}
		vis[idx] = false;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to, weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, M;
	static List<Edge>[] adj;
	static final int INF = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()); // N, M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()); // from, to, weight
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, weight));
			adj[to].add(new Edge(from, weight));
		}

		st = new StringTokenizer(in.readLine()); // s, t
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		int ans = Dijkstra(s, t);

		System.out.println(ans);
	}

	private static int Dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);
		pq.add(new Edge(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			int to = curr.to;
			if (to == end) return dist[end];
			if (vis[to]) continue;
			vis[to] = true;
			
			for (Edge next : adj[to]) {
				if (!vis[next.to] && dist[to] + next.weight < dist[next.to]) {
					dist[next.to] = dist[to] + next.weight;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
			
		}

		return dist[end];
	}
}

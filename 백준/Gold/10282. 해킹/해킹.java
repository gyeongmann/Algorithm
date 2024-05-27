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
	
	static int N, D, C;
	static List<Edge>[] adj;
	static final int INF = 10_000_000;
	
	static int[] dist;
	static boolean[] vis;
	static int max, cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine()); // 테스트 케이스 수
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine()); // N, D, C
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine()); // a, b, s
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				adj[from].add(new Edge(to, weight));
			}
			
			Dijkstra(C);
			sb.append(cnt + " " + max + '\n');
		} // test case
		System.out.println(sb);
	}

	private static void Dijkstra(int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		cnt = 0;
		vis = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		
		pq.add(new Edge(start, 0));
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			int to = curr.to;
			if (vis[to]) continue;
			vis[to] = true;
			cnt++;
			
			for (Edge next : adj[to]) {
				if (!vis[next.to] && dist[to] + next.weight < dist[next.to]) {
					dist[next.to] = dist[to] + next.weight;
					pq.add(new Edge(next.to, dist[next.to]));
				}
			}
		}
		
		max = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] < INF) max = Math.max(max, dist[i]);
		}
	}
}

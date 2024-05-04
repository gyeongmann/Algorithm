import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adj[a].add(new Edge(b, weight));
			adj[b].add(new Edge(a, weight));
		} // input

		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		visited[1] = true;
		for (Edge e : adj[1]) {
			pq.offer(e);
		}
		
		int maxWeight = 0;
		int cnt = 0;
		long ans = 0;
		while (cnt < N - 1) {
			Edge curr = pq.poll();
			int to = curr.to;
			if (visited[to]) continue;
			visited[to] = true;
			cnt++;
			maxWeight = Math.max(maxWeight, curr.weight);
			ans += curr.weight;
			
			for (Edge e : adj[to]) {
				if (!visited[e.to]) {
					pq.offer(e);
				}
			}
		}
		
		System.out.println(ans - maxWeight);
	}
}

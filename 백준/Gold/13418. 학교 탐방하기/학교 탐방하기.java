import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Edge {
		int to, cost;

		public Edge(int to, int cost) {
			this.to = to;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", cost=" + cost + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, M
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge>[] adj = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M + 1; i++) {
			st = new StringTokenizer(in.readLine()); // from, to, cost
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			adj[from].add(new Edge(to, cost));
			adj[to].add(new Edge(from, cost));
		}

		// 오름차순
		boolean[] vis = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>((edge1, edge2) -> {
			return Integer.compare(edge1.cost, edge2.cost);
		});

		vis[0] = true;
		pq.addAll(adj[0]);
		int cnt = 1;
		int ans1 = 0;
		while (cnt <= N) {
			Edge edge = pq.poll();
			if (vis[edge.to])
				continue;
//			System.out.println(edge);
			vis[edge.to] = true;
			ans1 += edge.cost;
			cnt++;
			pq.addAll(adj[edge.to]);
		}
		ans1 = N - ans1;
//		System.out.println(ans1);

		// 내림차순
		vis = new boolean[N + 1];
		pq = new PriorityQueue<>((edge1, edge2) -> {
			return Integer.compare(edge2.cost, edge1.cost);
		});

		vis[0] = true;
		pq.addAll(adj[0]);
		cnt = 1;
		int ans2 = 0;
		while (cnt <= N) {
			Edge edge = pq.poll();
			if (vis[edge.to])
				continue;
//			System.out.println(edge);
			vis[edge.to] = true;
			ans2 += edge.cost;
			cnt++;
			pq.addAll(adj[edge.to]);
		}
		ans2 = N - ans2;
//		System.out.println(ans2);
		int ans = (int) (Math.pow(ans1, 2) - Math.pow(ans2, 2));
		System.out.println(ans);
	}
}

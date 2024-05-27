import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class Edge implements Comparable<Edge> {
		int to, cost;

		public Edge(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	static int N, M;
	static final int INF = 100_000_000;

	static List<Edge>[] adj;
	static int[] dist, pre;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());

		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine()); // from, to, cost
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adj[from].add(new Edge(to, cost));
		}
		
		st = new StringTokenizer(in.readLine()); // start, end
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		Dijkstra(start, end);
	}

	private static void Dijkstra(int start, int end) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pre = new int[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, INF);
		vis = new boolean[N + 1];
		
		pq.add(new Edge(start, 0));
		pre[start] = start;
		dist[start] = 0;
		
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			int to = curr.to;
			if (vis[to]) continue;
			vis[to] = true;
			
			for (Edge next : adj[to]) {
				if (!vis[next.to] && dist[next.to] >= dist[to] + next.cost) {
					dist[next.to] = dist[to] + next.cost;
					pq.add(new Edge(next.to, dist[next.to]));
					pre[next.to] = to;
				}
			}
		}
		
		System.out.println(dist[end]);
		// 경로 춫력
		Stack<Integer> stack = new Stack<>();
		int preIdx = pre[end];
		stack.push(end);
		while (preIdx != start) {
			stack.push(preIdx);
			preIdx = pre[preIdx];
		}
		stack.push(start);
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}
}

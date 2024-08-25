import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node> {
		int next, weight;

		public Node(int next, int weight) {
			this.next = next;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [next=" + next + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, M;
	static final int INF = Integer.MAX_VALUE;
	static List<Node>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[from].add(new Node(to, weight));
		}
		
		int[] d = Dijkstra(start);
		
		int max = 0;
		for (int k = 1; k <= N; k++) {
            if (k == start) continue;
			int sum = Dijkstra(k)[start] + d[k];
			if (max < sum) {
				max = sum;
			}
		}
		
		System.out.println(max);

	}

	static int[] Dijkstra(int start) {
		int[] d = new int[N + 1];
		Arrays.fill(d, INF);
		d[start] = 0;
		boolean[] vis = new boolean[N + 1];

		// Dijkstra
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));

		while (!q.isEmpty()) {
			Node cur = q.poll();
			int stopOver = cur.next;

			if (vis[stopOver])
				continue;
			vis[stopOver] = true;

			for (Node fromSt : list[stopOver]) {
				if (d[stopOver] + fromSt.weight < d[fromSt.next]) {
					d[fromSt.next] = d[stopOver] + fromSt.weight;
					q.add(new Node(fromSt.next, d[fromSt.next]));
				}
			}
		}

		return d;
	}
}

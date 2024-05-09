import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int from, to;
		double weight;

		public Edge(int from, int to, double weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.weight, o.weight);
		}
	}

	static int N;
	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}

		Node[] nodes = new Node[N + 1];
		for (int idx = 1; idx <= N; idx++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			nodes[idx] = new Node(x, y);
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			union(a,b);
		} // input

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 1; i < N; i++) {
			for (int j = i + 1; j <= N; j++) {
				Node from = nodes[i];
				Node to = nodes[j];
				pq.offer(new Edge(i, j, getDistance(from, to)));
			}
		}
		
		double cost = 0;
		while (!pq.isEmpty()) {
			Edge curr = pq.poll();
			int from = curr.from;
			int to = curr.to;
			if (find(from) == find(to)) continue;
			union(from, to);
			cost += curr.weight;
		}

		System.out.printf("%.2f", cost);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		if (a != b) p[b] = a;
	}

	private static int find(int x) {
		if (p[x] == x)
			return x;
		return p[x] = find(p[x]);
	}

	private static double getDistance(Node a, Node b) {
		return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
	}
}

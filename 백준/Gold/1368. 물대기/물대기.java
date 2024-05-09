import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	static class Edge implements Comparable<Edge>{
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}
		
		
	}
	
	static int N;
	static PriorityQueue<Edge> pq;
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		pq = new PriorityQueue<>();
		
		int[] selfWeight = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			selfWeight[i] = Integer.parseInt(in.readLine());
		}
		// 1. make - set
		make();
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 1; j <= N; j++) {
				int w = Integer.parseInt(st.nextToken());
				if (i == j) {
					pq.add(new Edge(0, i, selfWeight[i]));
				} else if (i < j) {
					pq.add(new Edge(i, j, w));
				}
			}
		}
		
		// 2. 정렬된 간선하나씩 꺼내어 신장트리 생성
		int weight = 0;
		int cnt = 0;
		
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();
			if (!union(edge.from, edge.to)) continue;
			weight += edge.weight;
			if (++cnt == N) break;
		}
		
		System.out.println(weight);
	}
	
	static void make() {
		parents = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int a) {
		if (a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}

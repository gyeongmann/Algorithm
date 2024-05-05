import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Kruskal로 접근
 * -> 최소 비용인 간선으로 시작
 * Case 분류
 * 선택된 간선의 두 정점(의 부모)이
 * 1. 발전소인 경우 -> not union
 * 2. 하나는 발전소 하나는 도시인 경우 -> 발전소로 union
 * 3. 둘 다 아닌 경우 그냥 union
 */
public class Main {
	static class Edge implements Comparable<Edge> {
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

	static int N, M, K;
	static int[] p, electric;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()); // N, M, K
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		electric = new int[K];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			electric[i] = Integer.parseInt(st.nextToken());
		}

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new Edge(from, to, weight));
		} // input

		p = new int[N + 1];
		init();

		int E = 0;
		int cost = 0;
		while (E < N - K) {
			Edge curr = pq.poll();
			int a = curr.from;
			int b = curr.to;
			
			boolean isElectricA = isElectric(a);
			boolean isElectricB = isElectric(b);
			
			if (isElectricA && isElectricB) continue;
			if (find(a) == find(b)) continue;
			
			E++;
			cost += curr.weight;
			if (isElectricA) {
				union(a, b);
			} else {
				union(b, a);
			}
			
			setParent();
		}
		
		System.out.println(cost);
	}

	private static void init() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}

	// x가 발전소거나 발전소랑 연결됐거나
	private static boolean isElectric(int x) {
		x = find(x); // x의 root 찾기
		for (int i = 0; i < K; i++) {
			if (electric[i] == x)
				return true;
		}
		return false;
	}
	
	private static int find(int a) {
		if (p[a] == a) return a;
		return p[a] = find(p[a]);
	}
	
	private static void setParent() {
		for (int i = 1; i <= N; i++) {
			find(i);
		}
	}
	
	private static boolean union(int a, int b) { // b를 a에 union
		int aRoot = find(a);
		int bRoot = find(b);
		if (aRoot == bRoot) return false;
		p[bRoot] = aRoot;
		return true;
	}
}

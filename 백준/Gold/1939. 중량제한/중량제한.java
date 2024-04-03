import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 1. 이분탐색으로 중량 제한을 기준으로 최소와 최대 사이에서 중간값 탐색
 * 2. 기준을 넘는 간선들을 기준으로 주어진 두 섬을 갈 수 있는지 체크
 * 3. 못가면 기준 제한을 낮추고, 갈 수 있으면 높인다.
 * 4. 마지막 기준을 정답으로 초기화하고 출력
 */
public class Main {
	static class Edge implements Comparable<Edge> {
		int to;
		long weight;

		public Edge(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.weight, o.weight);
		}

		@Override
		public String toString() {
			return "Edge [to=" + to + ", weight=" + weight + "]";
		}
	}

	static int N, M;
	static List<Edge>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken()); // 섬의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		long min = Long.MAX_VALUE;
		long max = Long.MIN_VALUE;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Long.parseLong(st.nextToken());
			min = Math.min(min, C);
			max = Math.max(max, C);
			list[A].add(new Edge(B, C));
			list[B].add(new Edge(A, C));
		}

		st = new StringTokenizer(in.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
//		System.out.println(min + " " + max);
//		for (List edges : list) {
//			System.out.println(edges);
//		}
		
		// BFS + 이진탐색
		long left = min;
		long right = max;
		PriorityQueue<Edge> q = new PriorityQueue();
		long ans = 0;
		while (left <= right) {
			boolean[] visited = new boolean[N + 1];
			long mid = (left + right) / 2;
			for (Edge e : list[from]) {
				if (e.weight >= mid) q.add(e);
			}
			visited[from] = true; // 시작점에서 출발
			while (!q.isEmpty()) {
				Edge edge = q.poll();
				
				if (visited[edge.to]) continue;
				for (Edge e : list[edge.to]) {
					if (e.weight >= mid) q.add(e);
				}
				visited[edge.to] = true;
			}
			
			if (visited[to]) { // 목적지까지 갔으면 우측 탐색
				ans = mid;
				left = mid + 1;
				continue;
			}
			right = mid - 1;
		}
		
		System.out.println(ans);
	}
}

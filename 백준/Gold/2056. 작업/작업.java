import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Work implements Comparable<Work> {
		int idx, start, end; // 시작시간 끝시간

		public Work(int idx, int start, int end) {
			this.idx = idx;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public int compareTo(Work o) {
			return Integer.compare(this.end, o.end);
		}

		@Override
		public String toString() {
			return "work [idx=" + idx + ", start=" + start + ", end=" + end + "]";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		int[] degree = new int[N + 1]; // 위상정렬 차수
		int[] cost = new int[N + 1]; // 시간
		
		List<Integer>[] adj = new ArrayList[N + 1]; // 인접리스트
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int curr = 1; curr <= N; curr++) {
			st = new StringTokenizer(in.readLine());
			int c = Integer.parseInt(st.nextToken()); // 걸리는 시간
			cost[curr] = c;
			
			int pre = Integer.parseInt(st.nextToken()); // 선행 작업 개수
			degree[curr] = pre;
			for (int i = 0; i < pre; i++) {
				int from = Integer.parseInt(st.nextToken());
				adj[from].add(curr);
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(adj[i]);
//		}
//		System.out.println(Arrays.toString(degree));
		
		// 위상정렬
		PriorityQueue<Work> pq = new PriorityQueue<>();
		boolean[] vis = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				pq.add(new Work(i, 0, cost[i]));
				vis[i] = true;
			}
		}
		
//		System.out.println(pq);
		int ans = 0;
		while (!pq.isEmpty()) {
			int qSize = pq.size();
			for (int i = 0; i < qSize; i++) {
				Work curr = pq.poll();
				int end = curr.end; // 업무 끝 시간
				ans = Math.max(ans, end);
				for (int next : adj[curr.idx]) {
					degree[next]--;
					if (degree[next] == 0) {
						pq.add(new Work(next, end, end + cost[next]));
					}
//					if (!vis[next]) {
////							vis[next] = true;
//					}
				}
			}
//			System.out.println(pq);
		}
		System.out.println(ans);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이분 그래프
 * 하나가 1이면 다른 하나는 -1 이렇게 정점을 둘로 나눌 수 있는 그래프
 */

public class Main {
	static int V, E, color;
	static boolean isBinary;
	static int[] colored;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int K = Integer.parseInt(in.readLine()); // 테스트 케이스의 개수
		for (int tc = 1; tc <= K; tc++) {
			st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			adj = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(in.readLine());

				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adj[from].add(to);
				adj[to].add(from);
			} // 입력끝

			int start = 0; // 시작점
			for (int i = 1; i <= V; i++) {
				if (!adj[i].isEmpty()) {
					start = i;
					break;
				}
			}

			colored = new int[V + 1];
			isBinary = true;
			color = 1;
			
			for (int idx = 1; idx<= V; idx++) {
				if (isBinary && colored[idx] == 0) {
					BFS(idx);
				}
			}

			if (isBinary) sb.append("YES\n");
			else sb.append("NO\n");
		} // tc
		System.out.println(sb);
	}

	private static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(idx);
		colored[idx] = color;

		while (!q.isEmpty()) {
			int qSize = q.size();
			color *= -1;
			for (int i = 0; i < qSize; i++) {
				int curr = q.poll();
				for (int node : adj[curr]) {
					if (colored[node] == 0) {
						q.add(node);
						colored[node] = color;
						continue;
					}
					
					if (colored[node] != color) {
						isBinary = false;
						return;
					}
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] builds = new int[N + 1];
			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= N; i++) {
				builds[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] degree = new int[N + 1];
			adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<>();
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adj[from].add(to);
				degree[to]++;
			}
			
			Queue<Integer> q = new LinkedList<>();
			int[] ans = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				if (degree[i] == 0) {
					q.add(i);
					ans[i] += builds[i];
				}
			}
			
			while (!q.isEmpty()) {
				int idx = q.poll();
				
				for (int next : adj[idx]) {
					ans[next] = Math.max(ans[idx] + builds[next], ans[next]);
					degree[next]--;
					if (degree[next] == 0) q.add(next);
				}
			}
			
			int W = Integer.parseInt(in.readLine());
//			System.out.println(Arrays.toString(ans));
//			System.out.println(ans[W]);
			sb.append(ans[W]).append('\n');
		} // test case
		System.out.println(sb);
	}
}
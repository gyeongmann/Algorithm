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
	static int N, M, ans;
	static List<Integer>[] adj;
	static boolean[] vis;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			adj = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				adj[i] = new ArrayList<Integer>();
			}
			
			for (int line = 0; line < M; line++) {
				st = new StringTokenizer(in.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				adj[a].add(b);
				adj[b].add(a);
			}
			
			ans = 0;
			vis = new boolean[N + 1];
			
			for (int i = 1; i <= N; i++) {
				if (!vis[i])  {
					BFS(i);
				}
			}
			
			sb.append(ans + "\n");
		} // tc
		System.out.println(sb);
	}

	private static void BFS(int i) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		vis[i] = true;
		
		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int next : adj[curr]) {
				if (!vis[next]) {
					q.add(next);
					vis[next] = true;
					ans++;
				}
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] adj;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new List[N + 1];
		vis = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			adj[u].add(v);
			adj[v].add(u);
		}

		int answer = 0;
		for (int i = 1; i <= N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			answer++;
			dfs(i);
		}

		System.out.println(answer);
	}

	static void dfs(int u) {
		for (int v : adj[u]) {
			if (vis[v]) continue;
			vis[v] = true;
			dfs(v);
		}
	}
}

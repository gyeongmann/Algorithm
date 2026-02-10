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

		adj = new List[N];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		vis = new boolean[N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			if (dfs(i, 1)) {
				System.out.println(1);
				return;
			}
			vis[i] = false;
		}
		System.out.println(0);
	}

	static boolean dfs(int i, int depth) {
		if (depth == 5) {
			return true;
		}

		for (int n : adj[i]) {
			if (vis[n]) continue;
			vis[n] = true;
			if (dfs(n, depth + 1)) {
				return true;
			}
			vis[n] = false;
		}

		return false;
	}
}

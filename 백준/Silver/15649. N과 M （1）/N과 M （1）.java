import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static List<Integer>[] adj;
	static boolean[] vis;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		adj = new List[N + 1];
		for (int i = 0; i < N; i++) {
			adj[i] = new ArrayList<>();
		}
		vis = new boolean[N + 1];
		dfs(new int[M], 0);
		System.out.print(sb.toString());
	}

	static boolean dfs(int[] arr, int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return true;
		}

		for (int i = 1; i <= N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			arr[idx] = i;
			dfs(arr, idx + 1);
			vis[i] = false;
		}
		return false;
	}
}

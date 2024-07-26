import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		List<Integer>[] adj = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a].add(b);
			adj[b].add(a);
		}

		int[] depth = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();

		q.offer(1);
		int cnt = 0;
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;
		int leaf = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				depth[cur] = cnt;
				boolean isLeaf = true;
				for (int nxt : adj[cur]) {
					if (!visited[nxt]) {
						isLeaf = false;
						q.add(nxt);
						visited[nxt] = true;
					}
				}
				if (isLeaf) leaf += cnt;
			}
			cnt++;
		}
		if (leaf % 2 == 0) {
			System.out.println("No");
			return;
		}
		System.out.println("Yes");
	}
}
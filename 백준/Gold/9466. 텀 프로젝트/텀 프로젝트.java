import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int V;
	static int[] arr;
	static boolean[] vis;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			V = Integer.parseInt(in.readLine());
			int ans = V;
			arr = new int[V + 1];
			vis = new boolean[V + 1];

			st = new StringTokenizer(in.readLine());
			for (int i = 1; i <= V; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 1; i <= V; i++) {
				if (vis[i])
					continue;

				Queue<Integer> q = new LinkedList<>();
				q.add(i);
				vis[i] = true;

				int curr = i;
				int next = arr[curr];
				while (true) {
					if (vis[next])
						break;
					q.add(next);
					vis[next] = true;
					curr = next;
					next = arr[curr];
				}

				while (!q.isEmpty() && q.peek() != next) {
					q.poll();
				}
				ans -= q.size();
			}
			
			sb.append(ans + "\n");
		} // tc
		System.out.println(sb);
	}
}

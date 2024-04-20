import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());
		adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		while (true) {
			st = new StringTokenizer(in.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (a == -1)
				break;

			adj[a].add(b);
			adj[b].add(a);
		} // 입력 끝

		int depth;
		boolean[] visited;
		List<Point> candidate = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			Queue<Integer> q = new LinkedList<>();
			visited = new boolean[N + 1];
			depth = -1;
			q.add(i);
			visited[i] = true;

			while (!q.isEmpty()) {
				int qSize = q.size();
				for (int idx = 0; idx < qSize; idx++) {
					int curr = q.poll();
					for (int e : adj[curr]) {
						if (!visited[e]) {
							q.add(e);
							visited[e] = true;
						}
					}
				}
				depth++;
			}
			
			candidate.add(new Point(i, depth));
		}

		candidate.sort(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.y == o2.y) return Integer.compare(o1.x, o2.x);
				return Integer.compare(o1.y, o2.y);
			}
		});
		
		int minDepth = candidate.get(0).y;
		int cnt = 0;
		for (Point point : candidate) {
			if (point.y == minDepth) cnt++;
			else break;
		}
		
		System.out.println(minDepth + " " + cnt);
		for (int i = 0; i < cnt; i++) {
			System.out.print(candidate.get(i).x + " ");
		}
	}
}

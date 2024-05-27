import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Point implements Comparable<Point> {
		int r, c, weight;

		public Point(int r, int c, int weight) {
			super();
			this.r = r;
			this.c = c;
			this.weight = weight;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int N, M; // 열, 행
	static int[][] map, dist;
	static boolean[][] vis;
	static final int INF = 10_000;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, M

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int r = 0; r < M; r++) {
			String line = in.readLine();
			for (int c = 0; c < N; c++) {
				map[r][c] = Character.getNumericValue(line.charAt(c));
			}
		}

		Dijkstra(0, 0);
		System.out.println(dist[M - 1][N - 1]);
	}

	private static void Dijkstra(int r, int c) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		vis = new boolean[M][N];
		dist = new int[M][N];
		for (int[] row : dist) {
			Arrays.fill(row, INF);
		}

		pq.add(new Point(r, c, 0));
		dist[0][0] = map[r][c];

		while (!pq.isEmpty()) {
			Point curr = pq.poll();

			int row = curr.r;
			int col = curr.c;
			if (vis[row][col])
				continue;
			vis[row][col] = true;

			for (int dir = 0; dir < 4; dir++) {
				int nr = row + dr[dir];
				int nc = col + dc[dir];
				if (isValid(nr, nc) && !vis[nr][nc] && dist[nr][nc] > map[nr][nc] + dist[row][col]) {
					dist[nr][nc] = map[nr][nc] + dist[row][col];
					pq.add(new Point(nr, nc, dist[nr][nc]));
				}
			}
		}
	}

	private static boolean isValid(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= M || nc >= N)
			return false;
		return true;
	}
}

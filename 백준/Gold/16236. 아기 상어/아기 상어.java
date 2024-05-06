import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class BabyShark {
		int r, c, level, ate;

		private void levelUp() {
			this.ate = 0;
			level++;
		}
	}

	static class Pair implements Comparable<Pair>{
		int r, c, cnt;

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Pair o) {
			if (this.r == o.r) return Integer.compare(this.c, o.c);
			return Integer.compare(this.r, o.r);
		}

		@Override
		public String toString() {
			return "Pair [r=" + r + ", c=" + c + ", cnt=" + cnt + "]";
		}
	}

	static int N;
	static int[][] map;
	static BabyShark babyShark;

	// 상 좌 하 우
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(in.readLine());

		babyShark = new BabyShark();
		babyShark.level = 2;
		map = new int[N][N];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if (map[r][c] == 9) {
					babyShark.r = r;
					babyShark.c = c;
				}
			}
		}

		PriorityQueue<Pair> pq;
		int time = 0;
//		for (int[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println(time + " / level:" + babyShark.level);
//		System.out.println();
		while ((pq = searchFish()) != null) {
			Pair curr = pq.poll();
			time += curr.cnt;
			moveTo(curr);
			babyShark.ate++;
			if (babyShark.level == babyShark.ate) {
				babyShark.levelUp();
			}
//			System.out.println(curr);
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println(time + " / level:" + babyShark.level);
//			System.out.println();
		}
		System.out.println(time);
	}

	private static void moveTo(Pair pair) {
		map[babyShark.r][babyShark.c] = 0;
		map[pair.r][pair.c] = 9;
		babyShark.r = pair.r;
		babyShark.c = pair.c;
	}

	private static PriorityQueue<Pair> searchFish() {
		Queue<Pair> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		q.add(new Pair(babyShark.r, babyShark.c));
		visited[babyShark.r][babyShark.c] = true;

		int cnt = 1;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair curr = q.poll();
				int r = curr.r;
				int c = curr.c;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (isValid(nr, nc) && !visited[nr][nc]) {
						Pair pair = new Pair(nr, nc);
						if (0 < map[nr][nc] && map[nr][nc] < babyShark.level) {
							pair.cnt = cnt;
							pq.add(pair);
						}
						q.add(pair);
						visited[nr][nc] = true;
					}
				}
			}
			if (!pq.isEmpty()) return pq;
			cnt++;
		}

		return null;
	}

	private static boolean isValid(int nr, int nc) {
		// 범위를 벗어나거나 상어레벨보다 크면 false
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			return false;
		if (map[nr][nc] > babyShark.level)
			return false;
		return true;
	}
}

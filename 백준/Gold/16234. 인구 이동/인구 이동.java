import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, L, R;
	static boolean moved;
	static int[][] map;
	static boolean[][] visited;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken()); // 최소
		R = Integer.parseInt(st.nextToken()); // 최대

		map = new int[N][N];

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(in.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		} // input

		int day = 0;
		while (true) {
			moved = false;
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (!visited[r][c]) {
						BFS(r, c);
					}
				}
			}
			
			// 이동 없으면 break
			if (!moved)
				break;
			day++;
		}
		
		System.out.println(day);
	}

	private static void BFS(int row, int col) {
		Queue<Integer[]> q = new LinkedList<>();
		List<Integer[]> list = new ArrayList<>();
		q.add(new Integer[] { row, col });
		visited[row][col] = true;

		list.add(new Integer[] { row, col });
		int sum = map[row][col];
		while (!q.isEmpty()) {
			Integer[] curr = q.poll();
			int r = curr[0];
			int c = curr[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (isValid(nr, nc) && !visited[nr][nc] && canMove(r, c, nr, nc)) {
					q.add(new Integer[] { nr, nc });
					visited[nr][nc] = true;
					list.add(new Integer[] { nr, nc });
					sum += map[nr][nc];
					moved = true;
				}
			}
		}
		
		int avg = sum / list.size();
		for (Integer[] point : list) {
			map[point[0]][point[1]] = avg;
		}
	}

	private static boolean canMove(int r, int c, int nr, int nc) {
		int curr = map[r][c];
		int adj = map[nr][nc];
		int abs = Math.abs(curr - adj);
		if (L <= abs && abs <= R)
			return true;
		return false;
	}

	private static boolean isValid(int nr, int nc) { // out of bounds check
		if (nr < 0 || nr >= N || nc < 0 || nc >= N)
			return false;
		return true;
	}
}

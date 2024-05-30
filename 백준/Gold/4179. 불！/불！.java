import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Pair {
		int r, c;

		public Pair() {
		}

		public Pair(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int R, C;
	static char[][] map;

	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static Queue<Pair> fQ, jQ;
	static int[][] distFire, distJihoon;

	static final String FAIL = "IMPOSSIBLE";

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // R, C
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		distFire = new int[R][C];
		distJihoon = new int[R][C];
		fQ = new LinkedList<>();
		jQ = new LinkedList<>();

		for (int r = 0; r < R; r++) {
			String line = in.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
				distFire[r][c] = -1;
				distJihoon[r][c] = -1;
				if (map[r][c] == 'F') {
					fQ.add(new Pair(r, c));
					distFire[r][c] = 0;
				} else if (map[r][c] == 'J') {
					jQ.add(new Pair(r, c));
					distJihoon[r][c] = 0;
				}
			}
		} // input

		while (!fQ.isEmpty()) {
			Pair curr = fQ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) { // out of bounds
					continue;
				}
				if (distFire[nr][nc] >= 0 || map[nr][nc] == '#') { // 방문했거나 벽이면
					continue;
				}
				distFire[nr][nc] = distFire[curr.r][curr.c] + 1;
				fQ.add(new Pair(nr, nc));
			}
		}

		while (!jQ.isEmpty()) {
			Pair curr = jQ.poll();
			for (int dir = 0; dir < 4; dir++) {
				int nr = curr.r + dr[dir];
				int nc = curr.c + dc[dir];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C) { // out of bounds
					System.out.println(distJihoon[curr.r][curr.c] + 1);
					return;
				}
				if (distJihoon[nr][nc] >= 0 || map[nr][nc] == '#') { // 방문했거나 벽이면
					continue;
				}
				if (distFire[nr][nc] <= distJihoon[curr.r][curr.c] + 1 && distFire[nr][nc] >= 0) { // 불이 먼저 도착했으면
					continue;
				}
				distJihoon[nr][nc] = distJihoon[curr.r][curr.c] + 1;
				jQ.add(new Pair(nr, nc));
			}
		}

		System.out.println(FAIL);
	} // main
}

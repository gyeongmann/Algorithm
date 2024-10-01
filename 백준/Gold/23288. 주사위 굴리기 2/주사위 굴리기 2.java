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

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// BFS
		Queue<int[]> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][M];
		score = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					List<int[]> memo = new ArrayList<>();
					memo.add(new int[] {i, j});
					q.offer(new int[] {i, j});
					visited[i][j] = true;
					int cnt = 1;

					while (!q.isEmpty()) {
						int[] curr = q.poll();
						int r = curr[0];
						int c = curr[1];

						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];

							if (nr < 0 || nc < 0 || nr >= N || nc >= M)
								continue;
							if (!visited[nr][nc] && map[r][c] == map[nr][nc]) {
								memo.add(new int[] {nr, nc});
								q.offer(new int[] {nr, nc});
								visited[nr][nc] = true;
								cnt++;
							}
						}
					}

					for (int[] row : memo) {
						int r = row[0];
						int c = row[1];
						score[r][c] = map[r][c] * cnt;
					}
				}
			}
		} // BFS

		// for (int[] row : score) {
		// 	System.out.println(Arrays.toString(row));
		// }

		for (int i = 1; i <= K; i++) {
			roll();
			findDir(map);
			//
			// System.out.println(Arrays.toString(dice));
			// System.out.println("dir = " + dir);
			// System.out.println((curr[0] + 1) + "," + (curr[1] + 1) + " / " + ans);
			// System.out.println();
		}

		System.out.println(ans);
	} // main

	static int N, M, ans;

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};

	static int[] dice = {1, 6, 3, 4, 5, 2}; // 주사위 - 위, 아래, 오, 왼, 앞, 뒤
	static int dir = 0; // 0 - 동, 1 - 남, 2 - 서, 3 - 북
	static int[] curr = {0, 0}; // 현재 위치
	static int[][] score;

	static void findDir(int[][] map) {
		int A = dice[1];
		int B = map[curr[0]][curr[1]];
		if (A > B) {
			dir = (dir + 1) % 4;
		} else if (A < B) {
			dir = (dir + 3) % 4;
		}
	}

	static void roll() {
		int r = curr[0];
		int c = curr[1];
		int nr = r + dr[dir];
		int nc = c + dc[dir];

		if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
			dir = (dir + 2) % 4;
			nr = r + dr[dir];
			nc = c + dc[dir];
		}

		// 주사위 - 위, 아래, 오, 왼, 앞, 뒤
		int top = dice[0];
		int bottom = dice[1];
		int right = dice[2];
		int left = dice[3];
		int front = dice[4];
		int back = dice[5];

		if (dir == 0) { // 동쪽으로 움직이면
			bottom = dice[2];
			right = dice[0];
			top = dice[3];
			left = dice[1];
		} else if (dir == 1) { // 남
			bottom = dice[4];
			front = dice[0];
			top = dice[5];
			back = dice[1];
		} else if (dir == 2) { // 서
			left = dice[0];
			top = dice[2];
			right = dice[1];
			bottom = dice[3];
		} else if (dir == 3) { // 북
			top = dice[4];
			front = dice[1];
			bottom = dice[5];
			back = dice[0];
		}

		dice[0] = top;
		dice[1] = bottom;
		dice[2] = right;
		dice[3] = left;
		dice[4] = front;
		dice[5] = back;

		curr[0] = nr;
		curr[1] = nc;
		ans += score[curr[0]][curr[1]];
	}
}
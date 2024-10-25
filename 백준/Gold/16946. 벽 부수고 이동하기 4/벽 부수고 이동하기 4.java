import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx, cnt;

		public Node() {
			this.idx = 0;
			this.cnt = 0;
		}

		public Node(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] row = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = Character.getNumericValue(row[j]);
			}
		}

		Node[][] group = new Node[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				group[i][j] = new Node();
			}
		}
		int[] dr = {1, 0, -1, 0};
		int[] dc = {0, 1, 0, -1};
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> memo = new LinkedList<>();
		Queue<int[]> q = new LinkedList<>();

		int idx = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					memo.offer(new int[] {i, j});
					q.offer(new int[] {i, j});
					visited[i][j] = true;
					int cnt = 1;
					idx++;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						int r = cur[0];
						int c = cur[1];
						for (int k = 0; k < 4; k++) {
							int nr = r + dr[k];
							int nc = c + dc[k];

							if (nr < 0 || nc < 0 || nr >= N || nc >= M)
								continue;
							if (map[nr][nc] == 1 || visited[nr][nc])
								continue;
							memo.offer(new int[] {nr, nc});
							q.offer(new int[] {nr, nc});
							visited[nr][nc] = true;
							cnt++;
						}
					}

					while (!memo.isEmpty()) {
						int[] cur = memo.poll();
						group[cur[0]][cur[1]] = new Node(idx, cnt);
					}
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					boolean[] check = new boolean[idx + 1];
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						if (check[group[nr][nc].idx])
							continue;
						check[group[nr][nc].idx] = true;
						map[i][j] += group[nr][nc].cnt % 10;
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(map[i][j] % 10);
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}
}
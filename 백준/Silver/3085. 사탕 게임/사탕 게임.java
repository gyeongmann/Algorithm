import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		char[][] map = new char[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int max = 0;
		for (int i = 0; i < N; i++) {
			int row = rowCheck(map, i);
			int col = colCheck(map, i);
			max = Math.max(max, row);
			max = Math.max(max, col);
		}

		int[] move = {1, -1};
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 2; d++) {
					int nr = r + move[d];
					// 상 하 다른지
					if (nr < 0 || nr >= N)
						continue;
					if (map[r][c] == map[nr][c])
						continue;

					// swap
					swap(map, r, c, nr, c);

					// rowCheck
					max = Math.max(max, rowCheck(map, r));
					max = Math.max(max, colCheck(map, c));

					// swap
					swap(map, r, c, nr, c);
				}
			}
		}

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				for (int d = 0; d < 2; d++) {
					int nc = c + move[d];
					// 상 하 다른지
					if (nc < 0 || nc >= N)
						continue;
					if (map[r][c] == map[r][nc])
						continue;

					// swap
					swap(map, r, c, r, nc);

					// colCheck
					max = Math.max(max, rowCheck(map, r));
					max = Math.max(max, colCheck(map, c));

					// swap
					swap(map, r, c, r, nc);
				}
			}
		}

		System.out.println(max);
	}

	static private void swap(char[][] map, int r, int c, int nr, int nc) {
		char tmp = map[r][c];
		map[r][c] = map[nr][nc];
		map[nr][nc] = tmp;
	}

	static private int rowCheck(char[][] map, int row) {
		int max = 0;
		int count = 1;

		char prev = ' ';
		for (int i = 0; i < N; i++) {
			char curr = map[row][i];

			if (curr != prev) {
				max = Math.max(max, count);
				count = 1;
			} else {
				count++;
			}
			prev = curr;
		}

		max = Math.max(max, count);
		return max;
	}

	static private int colCheck(char[][] map, int col) {
		int max = 0;
		int count = 1;

		char prev = ' ';
		for (int i = 0; i < N; i++) {
			char curr = map[i][col];

			if (curr != prev) {
				max = Math.max(max, count);
				count = 1;
			} else {
				count++;
			}
			prev = curr;
		}

		max = Math.max(max, count);
		return max;
	}
}
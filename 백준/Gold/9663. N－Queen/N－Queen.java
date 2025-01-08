import java.util.Scanner;

public class Main {
	static int N, ans;
	static boolean[][] visited;

	static int[] dr = { -1, -1, -1 };
	static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt(); // 보드의 행과 열 크기
		ans = 0;
		visited = new boolean[N][N];
		put(0);

		System.out.println(ans);
	}

	// out of bounds check
	static boolean isValid(int nr, int nc) {
		if (nr < 0 || nc < 0 || nr >= N || nc >= N) {
			return false;
		}

		return true;
	}

	static boolean check(int r, int c) {
		for (int i = 0; i < 3; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			while (isValid(nr, nc)) {
				if (visited[nr][nc])
					return false;

				nr += dr[i];
				nc += dc[i];
			}
		}
		return true;
	}

	// idx : 퀸을 놓을 행 위치
	static void put(int idx) {
		if (idx == N) {
			ans++;
			return;
		}

		for (int i = 0; i < N; i++) {
			visited[idx][i] = true;
			if (check(idx, i))
				put(idx + 1);
			visited[idx][i] = false;
		}
	}

}

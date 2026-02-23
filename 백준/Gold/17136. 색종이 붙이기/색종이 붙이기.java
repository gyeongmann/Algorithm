import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] map = new int[10][10];
	static int[] papers = { 0, 5, 5, 5, 5, 5 };
	static int answer = 123456789;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		backTracking(0, 0);
		if (answer == 123456789) {
			System.out.println(-1);
			return;
		}

		System.out.println(answer);
	}

	static void backTracking(int rc, int useCnt) {
		if (rc == 100) {
			answer = Math.min(useCnt, answer);
			return;
		}

		int r = rc / 10;
		int c = rc % 10;

		if (answer <= useCnt) return; // backTracking
		if (map[r][c] == 1) {
			for (int i = 5; i >= 1; i--) {
				if (papers[i] > 0 && check(r, c, i)) {
					papers[i]--;
					fill(r, c, i, 0);
					backTracking(rc + 1, useCnt + 1);
					papers[i]++;
					fill(r, c, i, 1);
				}
			}
		} else {
			backTracking(rc + 1, useCnt);
		}
	}

	static void fill(int r, int c, int size, int num) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				map[i][j] = num;
			}
		}
	}

	static boolean check(int r, int c, int size) {
		if (r + size > 10 || c + size > 10) return false;
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (map[i][j] != 1) return false;
			}
		}
		return true;
	}
}

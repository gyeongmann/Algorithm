import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

	static class Pipe {
		int l, c; // 길이, 용량

		public Pipe() {
		}

		public Pipe(int l, int c) {
			this.l = l;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Pipe [l=" + l + ", c=" + c + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()); // D, P
		int D = Integer.parseInt(st.nextToken());// 목표 길이
		int P = Integer.parseInt(st.nextToken()); // 파이프 개수

		Pipe[] pipes = new Pipe[P + 1];
		for (int i = 1; i <= P; i++) {
			st = new StringTokenizer(in.readLine());
			int L = Integer.parseInt(st.nextToken()); // 길이
			int C = Integer.parseInt(st.nextToken()); // 용량
			pipes[i] = new Pipe(L, C);
		}
		
		int[][] dp = new int[P + 1][D + 1]; // 길이가 D일 때, 최대 용량
		
		for (int r = 1; r <= P; r++) {
			Pipe p = pipes[r];
			for (int c = 0; c < D; c++) {
				dp[r][c] = dp[r-1][c];
			}
			for (int c = p.l; c <= D; c++) {
				// 0. 파이프 자체 길이
				// 1. D를 만족할 수 있을 때,
				if (c == p.l) {
					dp[r][c] = Math.max(dp[r-1][c], p.c);
				} else {
					dp[r][c] = Math.max(Math.min(dp[r-1][c-p.l], p.c), dp[r-1][c]);
				}
			}
		}
		
//		for (int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		System.out.println(dp[P][D]);
	}
}
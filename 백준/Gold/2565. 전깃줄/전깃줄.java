import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Pair {
		int idx, num;

		public Pair(int idx, int num) {
			super();
			this.idx = idx;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Pair [idx=" + idx + ", num=" + num + "]";
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		Pair[] A = new Pair[N + 1];
		A[0] = new Pair(0, 0);
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine()); // idx, num
			int idx = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			A[i] = new Pair(idx, num);
		}
		
		Arrays.sort(A, (o1, o2) -> Integer.compare(o1.idx, o2.idx));
		
//		System.out.println(Arrays.toString(A));
		
		int[] dp = new int[N + 1];
//		dp[0] = 0;
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[j].num < A[i].num) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			cnt = Math.max(cnt, dp[i]);
		}
		
//		System.out.println(Arrays.toString(dp));
		System.out.println(N - cnt);
	}
}

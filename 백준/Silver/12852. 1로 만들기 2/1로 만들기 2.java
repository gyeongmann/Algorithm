import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());

		int[] dp = new int[N + 1];
		int[] route = new int[N + 1];

		dp[1] = 1;
//		if (N == 1) {
//			System.out.println(1);
//			System.out.println(1);
//			return;
//		}

		Arrays.fill(dp, 987654321);
		dp[1] = 0;
		route[1] = 1;
		for (int i = 1; i <= N; i++) {
			if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
				dp[i] = dp[i / 3] + 1;
				route[i] = i / 3;
			}
			if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
				dp[i] = dp[i / 2] + 1;
				route[i] = i / 2;
			}
			if (dp[i - 1] + 1 < dp[i]){
				dp[i] = dp[i - 1] + 1;
				route[i] = i - 1;
			}
		}
		
//		System.out.println(Arrays.toString(dp));
//		System.out.println(Arrays.toString(route));
		System.out.println(dp[N]);

		while (route[N] != N) {
			System.out.print(N + " ");
			N = route[N];
		}
		System.out.print(1 + " ");
	}
}
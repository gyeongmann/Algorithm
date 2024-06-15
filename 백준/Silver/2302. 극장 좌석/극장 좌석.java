import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		int[] dp = new int[41]; // 연속하는 좌석의 개수에서 나열하는 경우의 수
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= 40; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		int ans = 1;
		int M = Integer.parseInt(in.readLine()); // 고정석의 개수
		int before = 0;
		int next = 0;
		for (int i = 0; i < M; i++) {
			next = Integer.parseInt(in.readLine());
			int idx = next - before - 1;
			ans *= dp[idx];
			before = next;
		}
		ans *= dp[N - before];
		System.out.println(ans);
	}
}

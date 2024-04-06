import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] A;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		
		int ans = 0;
		int[] dp = new int[N];
		for (int k = 0; k < N; k++) {
			dp[k] = 1;
			for (int i = 0; i < k; i++) {
				if (A[i] < A[k]) {
					dp[k] = Math.max(dp[k], dp[i] + 1);
				}
			}
			ans = Math.max(ans, dp[k]);
		}
		
		System.out.println(ans);
	} // main
}

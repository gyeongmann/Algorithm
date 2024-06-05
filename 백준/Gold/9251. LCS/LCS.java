import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s1 = in.readLine();
		String s2 = in.readLine();
		
		int N = s1.length();
		int M = s2.length();
		int[][] dp = new int[N + 1][M + 1];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(j);
				
				if (ch1 == ch2) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					continue;
				}
				dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
			}
		}
		
//		for (int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		System.out.println(dp[N][M]);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String s1 = in.readLine();
		String s2 = in.readLine();
		
		int n = s1.length();
		int m = s2.length();
		int[][] dp = new int[n + 1][m + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
					continue;
				}
				
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		
		System.out.println(dp[n][m]);
//		for (int[] row : dp) {
//			System.out.println(Arrays.toString(row));
//		}
		
		StringBuilder sb = new StringBuilder();
		while (dp[n][m] > 0) {
			char ch1 = s1.charAt(n - 1);
			char ch2 = s2.charAt(m - 1);
			if (ch1 == ch2) {
				sb.append(ch1);
				n--; m--;
				continue;
			}
			
			if (dp[n - 1][m] > dp[n][m - 1]) {
				n--;
				continue;
			}
			m--;
		}
		sb.reverse();
		System.out.println(sb);
	}
}

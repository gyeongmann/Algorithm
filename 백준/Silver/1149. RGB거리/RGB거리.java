import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int[][] color, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		color = new int[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp = new int[N][3];
		for (int j = 0; j < 3; j++) {
			dp[0][j] = color[0][j];
		}
		
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				int beforeMin = Math.min(dp[i - 1][(j+1) % 3], dp[i - 1][(j+2) % 3]);
				dp[i][j] = color[i][j] + beforeMin;
			}
		}
		
		Arrays.sort(dp[N - 1]);
		System.out.println(dp[N - 1][0]);
		
	}
}

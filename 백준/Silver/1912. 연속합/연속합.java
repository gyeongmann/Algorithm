import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		int[] arr = new int[n];

		StringTokenizer st = new StringTokenizer(in.readLine());
		arr[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		dp[0] = arr[0];
		int min = Math.min(arr[0], 0);
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i-1], arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		
		System.out.println(dp[n-1]);
	}
}

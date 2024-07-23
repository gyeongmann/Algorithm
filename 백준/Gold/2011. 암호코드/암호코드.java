import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		int l = N.length();
		if (N.charAt(0) == '0') { // 0으로 시작하면
			System.out.println(0);
			return;
		}

		Set<String> set = new HashSet<>();
		for (int i = 1; i <= 26; i++) {
			set.add(String.valueOf(i));
		}

		int[] dp = new int[l + 1]; // i번째까지 가능한 암호의 수
		dp[0] = 1; // 첫 자리로 가능한 암호의 수
		dp[1] = 1;
		for (int i = 2; i <= l; i++) {
			String sub1 = N.substring(i - 1, i);
			if (set.contains(sub1)) {
				dp[i] = (dp[i] + dp[i - 1]) % 1000000;
			}
			String sub2 = N.substring(i - 2, i);
			if (set.contains(sub2)) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		System.out.println(dp[l]);
	}
}
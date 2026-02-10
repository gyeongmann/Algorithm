import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N;
	static String[] prime = { "1", "3", "5", "7", "9" };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs("2", 1);
		dfs("3", 1);
		dfs("5", 1);
		dfs("7", 1);
		System.out.println(sb.toString());
	}

	static void dfs(String s, int depth) {
		if (depth > N) {
			return;
		}

		if (!isPrime(s)) return;
		if (depth == N) {
			sb.append(s).append('\n');
			return;
		}

		for (int i = 0; i < 5; i++) {
			s += prime[i];
			dfs(s, depth + 1);
			s = s.substring(0, depth);
		}
	}

	static boolean isPrime(String s) {
		if (s.equals("1")) return false;
		int N = Integer.parseInt(s);
		int root = ((int) Math.sqrt(N)) + 1;

		for (int i = 2; i < root; i++) {
			if (N % i == 0) return false;
		}

		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static boolean find;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// System.out.println(isBad("1212"));
		int N = Integer.parseInt(br.readLine());

		solve("1", 0, N - 1);
	}

	static private void solve(String s, int idx, int N) {
		if (find)
			return;

		if (isBad(s))
			return;

		if (idx == N) {
			System.out.println(s);
			find = true;
			return;
		}

		if (s.charAt(idx) == '1') {
			solve(s + "2", idx + 1, N);
			solve(s + "3", idx + 1, N);
			solve(s.substring(0, idx) + "2", idx, N);
			solve(s.substring(0, idx) + "3", idx, N);
		} else if (s.charAt(idx) == '2') {
			solve(s + "1", idx + 1, N);
			solve(s + "3", idx + 1, N);
			solve(s.substring(0, idx) + "1", idx, N);
			solve(s.substring(0, idx) + "3", idx, N);
		} else if (s.charAt(idx) == '3') {
			solve(s + "1", idx + 1, N);
			solve(s + "2", idx + 1, N);
			solve(s.substring(0, idx) + "1", idx, N);
			solve(s.substring(0, idx) + "2", idx, N);
		}
	}

	static private boolean isBad(String str) {
		int l = str.length();
		for (int i = 1; i <= l / 2; i++) {
			for (int s = 0; s <= l - i * 2; s++) {
				String sub1 = str.substring(s, s + i);
				String sub2 = str.substring(s + i, s + 2 * i);
				// System.out.print(s + " " + (s + i) + " " + sub1 + " / ");
				// System.out.println((s + i) + " " + (s + i * 2) + " " + sub2);
				if (sub1.equals(sub2)) {
					return true;
				}
			}
		}

		return false;
	}
}
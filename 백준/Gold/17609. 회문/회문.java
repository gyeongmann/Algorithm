import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int i = 0; i < T; i++) {
			String s = in.readLine();
			System.out.println(palindromeCheck(s));
		}
	}

	private static int palindromeCheck(String s) {
		int left = 0;
		int right = s.length() - 1;
		boolean skip = false;
		boolean skipL = false;
		boolean skipR = false;
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++; right--;
			} else {
				skip = true;
				skipL = leftSkip(left + 1, right, s);
				skipR = rightSkip(left, right - 1, s);
				break;
			}
		}
		
		if (skip) {
			if (skipL || skipR) return 1;
			return 2;
		}
		return 0;
	}

	private static boolean leftSkip(int left, int right, String s) {
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++; right--;
				continue;
			}
			return false;
		}
		return true;
	}
	
	private static boolean rightSkip(int left, int right, String s) {
		while (left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++; right--;
				continue;
			}
			return false;
		}
		return true;
	}
}

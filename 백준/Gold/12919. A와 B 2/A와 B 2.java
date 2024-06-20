import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static final String A = "A";
	static final String B = "B";
	
	static int ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		String t = in.readLine();
		
		DFS(t, s);
		System.out.println(ans);
	}
	private static void DFS(String t, String s) {
		if (t.length() == s.length()) {
			if (t.equals(s)) {
				ans = 1;
			}
			return;
		}
		
		if (t.charAt(0) == 'B') {
			StringBuilder sb = new StringBuilder(t.substring(1));
			DFS(sb.reverse().toString(), s);
		}
		
		if (t.charAt(t.length() - 1) == 'A') {
			DFS(t.substring(0, t.length() - 1), s);
		}
	}
}

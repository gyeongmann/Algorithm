import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N, M, len, ans;
	static char[] ch = {'I', 'O'}, arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		M = Integer.parseInt(in.readLine());
		arr = in.readLine().toCharArray();
		
		len = 2 * N + 1;
		
		for (int i = 0; i <= M - len; i++) {
			if (arr[i] == 'I') {
				check(i);
			}
		}
		
		System.out.println(ans);
	}
	
	static void check(int i) {
		int flag = 0;
		for (int idx = 0; idx < len; idx++) {
			if (arr[i + idx] != ch[flag]) return;
			flag = (flag + 1) % 2;
		}
		ans++;
	}
}

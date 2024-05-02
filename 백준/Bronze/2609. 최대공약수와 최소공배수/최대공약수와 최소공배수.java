import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int GCD = gcd(a, b);
		int LCM = a * b / GCD;
		System.out.println(GCD);
		System.out.println(LCM);
	}

	private static int gcd(int a, int b) {
		while (a % b != 0) {
			a %= b;
			// swap
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		return b;
	}
}

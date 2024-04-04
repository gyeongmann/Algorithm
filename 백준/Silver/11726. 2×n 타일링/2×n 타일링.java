import java.util.Scanner;

public class Main {
	static long[] fibo;
	static {
		fibo = new long[1001];
		fibo[1] = 1;
		fibo[2] = 2;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(dp(n));
	}

	private static long dp(int n) {
		if (fibo[n] == 0) {
			fibo[n] = (dp(n-1) + dp(n-2)) % 10007;
		}
		return fibo[n];
	}
}

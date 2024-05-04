import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long right = n;
		long left = 1L;
		
		long ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2;
			
			long quotient = n / mid;
			if (quotient > mid) {
				left = mid + 1;
			} else if (quotient == mid) {
				if (mid * mid == n) {
					System.out.println(mid);
					return;
				} else if (mid * mid > n) {
					right = mid - 1;
					ans = mid;
				} else {
					left = mid + 1;
				}
			} else {
				right = mid - 1;
				ans = mid;
			}
		}
		
		System.out.println(ans);
	}
}

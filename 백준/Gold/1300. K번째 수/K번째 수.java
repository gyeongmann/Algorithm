import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		int left = 1;
		int right = k;
		int answer = -1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int cnt = count(N, mid);
			if (cnt < k) {
				left = mid + 1;
			} else {
				right = mid - 1;
				answer = mid;
			}
		}
		System.out.println(answer);
	}

	private static int count(int n, int mid) {
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			sum += Math.min(mid / i, n);
		}
		return sum;
	}
}

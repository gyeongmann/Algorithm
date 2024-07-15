import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(in.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(in.readLine());
		int max = 0;
		for (int i = 0; i < N; i++) {
			int cur = Integer.parseInt(st.nextToken());
			arr[i] = cur;
			max = Math.max(max, cur);
		}

		int limit = Integer.parseInt(in.readLine());

		int left = 0;
		int right = max;
		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < N; i++) {
				int curr = arr[i];
				if (curr > mid) {
					sum += mid;
					continue;
				}
				sum += curr;
			}

			if (sum > limit) {
				right = mid - 1;
			} else {
				left = mid + 1;
				ans = Math.max(ans, mid);
			}
		}

		System.out.println(ans);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, M
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int sum = 0;
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(st.nextToken());
			arr[i] = val;
			sum += val;
		}
		
		int left = 0;
		int right = sum;
		int mid = 0;
		int ans = Integer.MAX_VALUE;
		while (left <= right) {
			mid = (left + right) / 2;
			// 만족하면
			if (calculate(mid)) {
				right = mid - 1;
				ans = Math.min(ans, mid);
			} else {
				left = mid + 1;
			}
		}
		
		System.out.println(ans);
	}

	private static boolean calculate(int limit) {
		int idx = 0;
		for (int i = 0; i < M; i++) {
			int sum = 0;
			while (true) {
				if (idx == N) return true;
				if (sum + arr[idx] <= limit) {
					sum += arr[idx++];
				} else {
					break;
				}
			}
		}
		return false;
	}
}
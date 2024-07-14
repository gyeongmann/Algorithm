import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, M
		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 필요한 나무의 길이
		
		long[] trees = new long[N];
		long max = 0;
		st = new StringTokenizer(in.readLine()); // 나무 높이들
		for (int i = 0; i < N; i++) {
			long curr = Long.parseLong(st.nextToken());
			max = Math.max(max, curr);
			trees[i] = curr;
		}
		
		long left = 0;
		long right = max;
		long ans = 0;
		while (left <= right) {
			long mid = (left + right) / 2; // 설정 나무 높이
			
			long sum = 0;
			for (int i = 0; i < N; i++) {
				if (trees[i] > mid) {
					sum += trees[i] - mid;
				}
			}
			
			if (sum >= M) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(ans);
	}
}
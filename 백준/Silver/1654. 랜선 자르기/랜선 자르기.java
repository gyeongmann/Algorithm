import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // N, K
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[N];
		for (int i = 0; i < N; i++) {
			lan[i] = Integer.parseInt(in.readLine());
		}
		
		System.out.println(binarySearch(lan, K));
	}

	private static long binarySearch(int[] lan, int k) {
		Arrays.sort(lan);
		long left = 1;
		long right = lan[lan.length - 1];
		long mid = (left + right) / 2;
		long ans = 0;
		while (left <= right) {
			int cnt = count(lan, mid);
			if (cnt < k) { // 랜선의 길이가 너무 크면 길이 줄이기
				right = mid - 1;
			} else {
				ans = Math.max(ans, mid);
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		return ans;
	}

	private static int count(int[] lan, long mid) {
		int cnt = 0;
		for (int i = 0; i < lan.length; i++) {
			cnt += lan[i] / mid;
		}
		return cnt;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 두 개의 수를 가져온다.
 * 2. 절대값이 반대 되는 수에 가까운 수를 가져온다.
 */
public class Main {
	static int N;
	static long abs;
	static long[] arr, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		arr = new long[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		Arrays.sort(arr);
		abs = Long.MAX_VALUE;
		// 1.
		ans = new long[3];
		for (int p1 = 0; p1 < N - 2; p1++) {
			for (int p2 = p1 + 1; p2 < N - 1; p2++) {
				binarySearch(p1, p2);
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.print(ans[i] + " ");
		}
	}
	private static void binarySearch(int p1, int p2) {
		int left = p2 + 1;
		int right = N - 1;
		long sum = arr[p1] + arr[p2];
		int mid = 0;
		while (left <= right) {
			mid = (left + right) / 2;
			long cur = arr[mid] + sum;
			if (Math.abs(cur) < abs) {
				abs = Math.min(Math.abs(cur), abs);
				ans[0] = arr[p1];
				ans[1] = arr[p2];
				ans[2] = arr[mid];
			}
			if (cur > 0) { // cur가 0보다 크면, 좌측 탐색
				right = mid - 1;
			}
			else if (cur < 0) { // 0보다 작으면, 우측 탐색
				left = mid + 1;
			}
			else break;
		}
		
//		System.out.println(arr[p1] + " " + arr[p2] +" " + arr[mid]);
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, right;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			right += A[i];
		}

		int result = parametricSearch();
		System.out.println(result);
	}

	private static int parametricSearch() {
		int left = 1;
		int answer = right;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			if (isAvailable(mid)) {
				answer = Math.min(mid, answer);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}

	private static boolean isAvailable(int mid) {
		int idx = 0;
		int cnt = 1;
		int sum = 0;
		while (idx < N) {
			if (cnt > M) {
				return false;
			}
			if (sum + A[idx] > mid) {
				sum = 0;
				cnt++;
				continue;
			}
			sum += A[idx++];
		}

		return true;
	}
}

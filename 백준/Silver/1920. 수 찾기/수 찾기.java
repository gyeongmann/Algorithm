import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] A;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);

		int M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (binarySearch(x)) {
				sb.append("1").append('\n');
			} else {
				sb.append("0").append('\n');
			}
		}
		System.out.println(sb.toString());
	}

	private static boolean binarySearch(int x) {
		int left = 0,
			right = N - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (A[mid] == x) {
				return true;
			} else if (A[mid] < x) {
				left = mid + 1;
			} else if (A[mid] > x) {
				right = mid - 1;
			}
		}
		return false;
	}
}

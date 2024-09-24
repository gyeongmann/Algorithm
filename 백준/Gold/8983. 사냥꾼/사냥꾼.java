import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 사대의 수
		int N = Integer.parseInt(st.nextToken()); // 동물의 수
		int L = Integer.parseInt(st.nextToken()); // 사정거리

		st = new StringTokenizer(br.readLine()); // 1 4 6 9
		int[] arr = new int[M];
		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		int cnt = 0;
		for (int j = 0; j < N; j++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int left = 0;
			int right = M - 1;
			int dis = 0;

			while (left <= right) {
				int mid = left + (right - left) / 2;

				if (arr[mid] < a) {
					dis = a - arr[mid] + b;
					if (dis <= L) {
						cnt++;
						break;
					}
					left = mid + 1;
				} else if (arr[mid] > a) {
					dis = arr[mid] - a + b;
					if (dis <= L) {
						cnt++;
						break;
					}
					right = mid - 1;
				} else {
					if (b <= L) {
						cnt++;
					}
					break;
				}
			}

		}
		System.out.println(cnt);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // N, H
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[] top = new int[N / 2];
		int[] bottom = new int[N - N / 2];
		for (int i = 0; i < N; i++) {
			int length = Integer.parseInt(br.readLine());
			if (i % 2 != 0) {
				top[i / 2] = length;
				continue;
			}
			bottom[i / 2] = length;
		}

		Arrays.sort(top);
		Arrays.sort(bottom);

		int min = N;
		int cnt = 0;
		for (int target = 1; target <= H; target++) {
			int curr = binarySearch(top, H - target + 1) + binarySearch(bottom, target);
			if (curr < min) {
				min = curr;
				cnt = 1;
			} else if (curr == min) {
				cnt++;
			}
		}

		System.out.println(min + " " + cnt);
	}

	static int binarySearch(int[] arr, int target) {
		int left = 0, right = arr.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return arr.length-right;
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0;
		int right = N - 1;

		int answer = Integer.MAX_VALUE;
		int leftIdx = 0;
		int rightIdx = 0;
		while (left < right) {
			int curr = arr[left] + arr[right];
			if (curr > 0) {
				if (curr < answer) {
					answer = curr;
					leftIdx = left;
					rightIdx = right;
				}
				right--;
			} else if (curr < 0) {
				if (-curr < answer) {
					answer = -curr;
					leftIdx = left;
					rightIdx = right;
				}
				left++;
			} else if (curr == 0) {
				leftIdx = left;
				rightIdx = right;
				break;
			}
		}

		System.out.println(arr[leftIdx] + " " + arr[rightIdx]);
	}
}
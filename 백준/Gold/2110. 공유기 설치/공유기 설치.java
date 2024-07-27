import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // N, C
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] houses = new int[N];
		for (int i = 0; i < N; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(houses);
		// 1 2 4 8 9
		//  1 2 4 1
		// mid : 4
		// 1 (5<=)8 -> 12 -- x
		// mid : 2
		// 1 (3<=)4 (6<=)8
		// mid : 3
		// 1 (4<=)4 (7<=)8
		// 매개변수 탐색
		int left = 0;
		int right = houses[N-1] - houses[0];

		int ans = 0;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (count(houses, mid) >= C) {
				left = mid + 1;
				ans = Math.max(ans, mid);
			} else {
				right = mid - 1;
			}
		}
		System.out.println(ans);
	}

	private static int count(int[] arr, int minGap) {
		int cnt = 1;
		int start = arr[0];
		int end = arr[arr.length - 1];
		int curr = start + minGap;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < curr) continue;
			curr = arr[i] + minGap;
			cnt++;
		}
		return cnt;
	}
}
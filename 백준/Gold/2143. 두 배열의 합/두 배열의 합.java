import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. 누적합 개념을 이용해 부분배열의 합 원소들을 생성 및 배열에 삽입
 * 2. 한 배열을 순회하며, 목적수와 차이를 타겟으로 두고 다른 배열에서 이분탐색
 * 3. upperBound - lowerBound로 개수 합산
 */
public class Main {
	static long T;
	static int n, m;
	static long[] A, B, prefixA, prefixB;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Long.parseLong(in.readLine());

		// A 배열 입력
		n = Integer.parseInt(in.readLine());
		A = new long[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < n; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		prefixA = new long[n * (n + 1) / 2];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			long sum = A[i]; // 시작점 초기화
			prefixA[idx++] = sum;
			for (int j = i + 1; j < n; j++) {
				sum += A[j];
				prefixA[idx++] = sum;
			}
		}

		// B 배열 입력
		m = Integer.parseInt(in.readLine());
		B = new long[m];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < m; i++) {
			B[i] = Integer.parseInt(st.nextToken());
		}

		prefixB = new long[m * (m + 1) / 2];
		idx = 0;
		for (int i = 0; i < m; i++) {
			long sum = B[i]; // 시작점 초기화
			prefixB[idx++] = sum;
			for (int j = i + 1; j < m; j++) {
				sum += B[j];
				prefixB[idx++] = sum;
			}
		}

		Arrays.sort(prefixA);
		Arrays.sort(prefixB);
		
		long ans = 0;
		for (int i = 0; i < prefixA.length; i++) {
			long cur = prefixA[i];
			long target = T - cur;
			ans += upperBound(target, prefixB) - lowerBound(target, prefixB);
		}
		System.out.println(ans);
	} // main

	private static int lowerBound(long target, long[] arr) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] >= target) right = mid;
			else left = mid + 1;
		}
		return left;
	}

	private static int upperBound(long target, long[] arr) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = (left + right) / 2;
			if (arr[mid] > target) right = mid;
			else left = mid + 1;
		}
		return left;
	}

}

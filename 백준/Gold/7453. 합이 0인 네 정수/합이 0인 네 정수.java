import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 1. A,B의 합 배열, C,D의 합 배열 생성
 * 2. 두 배열을 각각 정렬한 뒤 나열
 * 3. 투 포인터로 양 끝에서 0이 되는 개수 탐색
 */
public class Main {
	static long[] a, b, c, d, sum1, sum2;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(in.readLine());
		a = new long[n];
		b = new long[n];
		c = new long[n];
		d = new long[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		sum1 = new long[n * n];
		sum2 = new long[n * n];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum1[idx] = a[i] + b[j];
				sum2[idx] = c[i] + d[j];
				idx++;
			}
		}
		
		Arrays.sort(sum1);
		Arrays.sort(sum2);
		
		int left = 0;
		int right = sum2.length - 1;
		long ans = 0;
		while (left < sum1.length && right >= 0) {
			long cur = sum1[left] + sum2[right];
			if (cur > 0) right--;
			else if (cur < 0) left++;
			else {
				long leftCnt = 1;
				long rightCnt = 1;
				while (left + 1 < sum1.length && sum1[left] == sum1[left+1]) {
					leftCnt++;
					left++;
				}
				while (right - 1 >= 0 && sum2[right] == sum2[right-1]) {
					rightCnt++;
					right--;
				}
				ans += leftCnt * rightCnt;
				left++;
			}
		}
		
		System.out.println(ans);
	}
}

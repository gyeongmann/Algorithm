import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 1. i번째 스위치를 눌렀을 때,
 * 	  (i-1, i, i+1)이 바뀌는 것이 아닌
 * 	  (i, i+1, i+2)로 바뀌는 것으로 생각
 * 		-> 누른 곳 이전이 바뀌지 않으므로, 다른 부분만 고려하는 연산 가능
 * 2. 1,2번 스위치가 변경되는 연산은 불가능하므로 1,2번을 누른 것과 누르지 않은 것 두 버전으로 시작
 * 3. 연산 변경으로 마지막에서 2번째까지만 누를 수 있고, 두 버전 모두 마지막 숫자가 다른 경우 -1 출력
 */
public class Main {
	static int N;
	static int[] ans;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());
		String from = in.readLine();
		String to = in.readLine();

		int[] origin = new int[N];
		ans = new int[N];
		for (int i = 0; i < N; i++) {
			origin[i] = from.charAt(i) - '0';
			ans[i] = to.charAt(i) - '0';
		}

		int[] v1 = Arrays.copyOfRange(origin, 0, N); // 1,2번 누른 배열
		v1[0] = 1 - v1[0];
		v1[1] = 1 - v1[1];
		int[] v2 = Arrays.copyOfRange(origin, 0, N);

		int cnt1 = cal(v1, true);
		int cnt2 = cal(v2, false);
		
		int answer = Math.min(cnt1, cnt2);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1); // 둘 다 불가능
			return;
		}
		System.out.println(answer);
	}

	private static int cal(int[] arr, boolean isClicked) {
		int cnt = 0;
		if (isClicked)
			cnt = 1;
		
		for (int i = 0; i <= N - 3; i++) {
			if (arr[i] != ans[i]) {
				arr[i] = 1-arr[i];
				arr[i+1] = 1-arr[i+1];
				arr[i+2] = 1-arr[i+2];
				cnt++;
			}
		}
		if (arr[N - 2] != ans[N - 2]) {
			arr[N - 2] = 1 - arr[N - 2];
			arr[N - 1] = 1 - arr[N - 1];
			cnt++;
		}
		
		if (arr[N - 1] != ans[N - 1]) { // 불가능
			return Integer.MAX_VALUE;
		}
		return cnt;
	}
}

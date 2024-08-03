import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] total, center;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()); // N, X

		int N = Integer.parseInt(st.nextToken());
		long X = Long.parseLong(st.nextToken());

		// 1. 전체 레이어 수
		total = new long[N + 1];
		total[0] = 1;
		for (int i = 1; i <= N; i++) {
			total[i] = 2 * total[i - 1] + 3;
		}

		// 2. 가운데 위치 = 전체 패티 수
		center = new long[N + 1];
		for (int i = 0; i <= N; i++) {
			center[i] = total[i] / 2 + 1;
		}

		long ans = solve(N, X);

		System.out.println(ans);
	}

	private static long solve(int N, long X) {
		if (N == 0) {
			if (X == 0) {
				return 0;
			}
			return 1;
		}
		if (X == 0) {
			return 0;
		}
		if (X > center[N]) {
			return solve(N, center[N]) + solve(N - 1, X - center[N]);
		}
		if (X == center[N]) {
			return center[N] / 2 + 1;
		}
		return solve(N - 1, X - 1);
	}
}
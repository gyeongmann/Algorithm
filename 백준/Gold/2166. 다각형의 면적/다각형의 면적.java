import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		long[][] arr = new long[N+1][2];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Long.parseLong(st.nextToken());
			arr[i][1] = Long.parseLong(st.nextToken());
		}
		arr[0][0] = arr[N][0];
		arr[0][1] = arr[N][1];

		long sum = 0;
		for (int i = 1; i < N; i++) {
			sum += arr[i][0] * (arr[i+1][1] - arr[i-1][1]);
		}
		sum += arr[N][0] * (arr[1][1] - arr[N-1][1]);

		if (sum < 0) sum *= -1;
		String ans = String.format("%.1f", sum / 2.0);
		System.out.println(ans);
	}
}
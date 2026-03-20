import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		boolean[] isNotPrime = new boolean[N + 1];
		isNotPrime[1] = true;
		int sqrtN = (int) Math.sqrt(N);
		for (int i = 2; i <= sqrtN; i++) {
			if (isNotPrime[i]) continue;
			int idx = 2;
			while (i * idx <= N) {
				isNotPrime[i * idx] = true;
				idx++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = M; i <= N; i++) {
			if (!isNotPrime[i]) {
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.sort(arr[i]);
		}

		int[] idx = new int[N];

		int ans = 1_000_000_001;
		for (int j = 0; j < N * M; j++) {
			int min = arr[0][idx[0]];
			int max = arr[0][idx[0]];
			int minIdx = 0;
			int maxIdx = 0;
			for (int i = 1; i < N; i++) {
				if (arr[minIdx][idx[minIdx]] > arr[i][idx[i]]) {
					minIdx = i;
					min = arr[minIdx][idx[minIdx]];
				}

				if (arr[maxIdx][idx[maxIdx]] < arr[i][idx[i]]) {
					maxIdx = i;
					max = arr[maxIdx][idx[maxIdx]];
				}
			}

			ans = Math.min(ans, max - min);

			idx[minIdx]++;
			if (idx[minIdx] == M) {
				break;
			}
		}

		System.out.println(ans);
	}
}
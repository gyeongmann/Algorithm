import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] D = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j) continue;
				D[i][j] = INF;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			D[from][to] = 1;
		}
		
		for (int mid = 1; mid <= N; mid++) {
			for (int from = 1; from <= N; from++) {
				for (int to = 1; to <= N; to++) {
					D[from][to] = Math.min(D[from][to], D[from][mid] + D[mid][to]);
				}
			}
		}
		
		int[] compareCnt = new int[N+1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (0 < D[i][j] && D[i][j] < INF) {
					compareCnt[i]++;
					compareCnt[j]++;
				}
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			if (compareCnt[i] == N - 1) ans++;
		}
		
		System.out.println(ans);
	}
}

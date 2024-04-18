import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int N, M, K;
	static char[][] map;
	static Map<String, Integer> cnt;

	static int[] dr = { 1, 1, 1, 0, -1, -1, -1, 0 };
	static int[] dc = { 1, 0, -1, -1, -1, 0, 1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
			}
		}

		cnt = new HashMap<>();
		for (int i = 0; i < K; i++) {
			String word = in.readLine();
			if (cnt.containsKey(word)) {
				System.out.println(cnt.get(word));
				continue;
			}
			cnt.put(word, 0);
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					DFS(r, c, word, 1, String.valueOf(map[r][c]));
				}
			}
			
			System.out.println(cnt.get(word));
		}
	}

	private static void DFS(int r, int c, String word, int l, String s) {
		if (l == word.length()) {
			if (s.equals(word)) {
				int curr = cnt.get(word) + 1;
				cnt.put(word, curr);
			}
			return;
		}
		
		if (map[r][c] != word.charAt(l-1)) return; // 현재 위치가 정답 문자와 다르면 return
		
		for (int i = 0; i < 8; i++) {
			int nr = (r + dr[i] + N) % N;
			int nc = (c + dc[i] + M) % M;
			DFS(nr, nc, word, l + 1, s + String.valueOf(map[nr][nc]));
		}
	}
}
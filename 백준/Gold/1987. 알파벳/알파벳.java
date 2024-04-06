import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans;
	static char[][] map;
	
	static String trace;
	static int[] dr = {1, 0, -1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int r = 0; r < R; r++) {
			String line = in.readLine();
			for (int c = 0; c < C; c++) {
				map[r][c] = line.charAt(c);
			}
		} // 입력 끝
		
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
		
		trace = String.valueOf(map[0][0]);
		
		DFS(0, 0, 1);
		System.out.println(ans);
	}
	

	private static void DFS(int r, int c, int sum) {
//		System.out.println(trace + " - start");
//		System.out.println(r + " " + c + " / " + sum);
		ans = Math.max(ans, sum);
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (isValid(nr, nc)) {
				if (trace.contains(String.valueOf(map[nr][nc]))) continue;
				trace += String.valueOf(map[nr][nc]);
				DFS(nr, nc, sum + 1);
				trace = trace.substring(0, trace.length() - 1);
//				System.out.println(trace + " - end");
			}
		}
		
	}

	private static boolean isValid(int r, int c) {
		if (r < 0 || r >= R || c < 0 || c >= C) return false;
		return true;
	}
}

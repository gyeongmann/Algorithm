import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C;
	static char[][] map;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // R, C
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		
		for (int r = 0; r < R; r++) {
			if (DFS(r, 0)) {
				cnt++;
			}
			
//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
			
		}
		
		System.out.println(cnt);
	}
	
	private static boolean DFS(int r, int c) {
		map[r][c] = 'o';
		
//		for (char[] row : map) {
//			System.out.println(Arrays.toString(row));
//		}
//		System.out.println();
		
		if (c == C - 1) {
			return true;
		}
		
		if (r - 1 >= 0 && map[r-1][c+1] == '.') {
			if (DFS(r - 1, c + 1)) {
				return true;
			}
		}
		if (map[r][c+1] == '.') {
			if (DFS(r, c + 1)) {
				return true;
			}
		}
		if (r + 1 < R && map[r+1][c+1] == '.') {
			if (DFS(r + 1, c + 1)) {
				return true;
			}
		}
		
		// map[r][c] = '.';
		return false;
	}
}

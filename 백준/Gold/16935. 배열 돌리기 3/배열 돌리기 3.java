import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		String[][] map = new String[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken();
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int idx = 0; idx < R; idx++) {
			int op = Integer.parseInt(st.nextToken());

			if (op == 1) {
				int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[r][c];

				for (int i = 0; i < r; i++) {
					nmap[i] = map[r-i-1];
				}
				map = nmap;
			} else if (op == 2) {
				int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[r][c];

				for (int i = 0; i < r; i++) {
					for (int j = 0; j < c; j++) {
						nmap[i][j] = map[i][c-1-j];
					}
				}
				map = nmap;
			} else if (op == 3) {
				int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[c][r];

				for (int i = 0; i < c; i++) {
					for (int j = 0; j < r; j++) {
						nmap[i][j] = map[r-1-j][i];
					}
				}
				map = nmap;
			} else if (op == 4) {
				int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[c][r];

				for (int i = 0; i < c; i++) {
					for (int j = 0; j < r; j++) {
						nmap[i][j] = map[j][c-1-i];
					}
				}
				map = nmap;
			} else if (op == 5) {
			    int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[r][c];
				
				for (int i = 0; i < r/2; i++) {
				    for (int j = 0; j < c/2; j++) {
				        nmap[i][j] = map[i+r/2][j];
				    }
				}
				
				for (int i = 0; i < r/2; i++) {
				    for (int j = c/2; j < c; j++) {
				        nmap[i][j] = map[i][j-c/2];
				    }
				}
				
				for (int i = r/2; i < r; i++) {
				    for (int j = c/2; j < c; j++) {
				        nmap[i][j] = map[i-r/2][j];
				    }
				}
				
				for (int i = r/2; i < r; i++) {
				    for (int j = 0; j < c/2; j++) {
				        nmap[i][j] = map[i][j+c/2];
				    }
				}
				
				map = nmap;
			} else if (op == 6) {
			    int r = map.length;
				int c = map[0].length;
				String[][] nmap = new String[r][c];
				
				for (int i = 0; i < r/2; i++) {
				    for (int j = 0; j < c/2; j++) {
				        nmap[i][j] = map[i][j+c/2];
				    }
				}
				
				for (int i = 0; i < r/2; i++) {
				    for (int j = c/2; j < c; j++) {
				        nmap[i][j] = map[i+r/2][j];
				    }
				}
				
				for (int i = r/2; i < r; i++) {
				    for (int j = c/2; j < c; j++) {
				        nmap[i][j] = map[i][j-c/2];
				    }
				}
				
				for (int i = r/2; i < r; i++) {
				    for (int j = 0; j < c/2; j++) {
				        nmap[i][j] = map[i-r/2][j];
				    }
				}
				
				map = nmap;
			}
		}

		StringBuilder sb = new StringBuilder();
		int r = map.length;
		int c = map[0].length;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				sb.append(map[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}

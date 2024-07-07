import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int r, c, dir, cnt;

		public Node(int r, int c, int dir, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cnt, o.cnt);
		}

		@Override
		public String toString() {
			return "Node [r=" + r + ", c=" + c + ", dir=" + dir + ", cnt=" + cnt + "]";
		}
	}

	// 남, 동, 북, 서
	static int[] dr = { 1, 0, -1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static final int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // W: 열, H: 행

		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		char[][] map = new char[H][W];

		List<Node> list = new ArrayList<>();
		for (int r = 0; r < H; r++) {
			String s = in.readLine();
			for (int c = 0; c < W; c++) {
				char ch = s.charAt(c);
				map[r][c] = ch;

				if (ch == 'C') {
					list.add(new Node(r, c, -1, 0));
				}
			}
		} // input

		int[][][] vis = new int[4][H][W]; // 방향, 행 좌표, 열 좌표
		for (int dir = 0; dir < 4; dir++) {
			for (int[] row : vis[dir]) {
				Arrays.fill(row, INF);
			}
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		Node start = list.get(0);
		for (int dir = 0; dir < 4; dir++) {
			pq.add(new Node(start.r, start.c, dir, 0));
			vis[dir][start.r][start.c] = 0;
		}

		Node end = list.get(1);
		int ans = INF;
		
		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			int r = curr.r;
			int c = curr.c;
			int dir = curr.dir;
			int cnt = curr.cnt;
			
			if (r == end.r && c == end.c) {
				ans = Math.min(ans, cnt);
				continue;
			}

			for (int nDir = 0; nDir < 4; nDir++) {
				if (nDir == (dir + 2) % 4)
					continue;

				int nr = r + dr[nDir];
				int nc = c + dc[nDir];

				if (nr < 0 || nc < 0 || nr >= H || nc >= W)
					continue;
				if (map[nr][nc] == '*')
					continue;

				int nCnt = cnt;
				if (nDir != dir) {
					nCnt++;
				}

				if (vis[nDir][nr][nc] > nCnt) {
					pq.add(new Node(nr, nc, nDir, nCnt));
					vis[nDir][nr][nc] = nCnt;
				}
			}
		}

		System.out.println(ans);
	}
}
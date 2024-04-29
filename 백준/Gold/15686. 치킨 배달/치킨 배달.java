import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, size, min;
	static int[][] map;
	static List<Point> chicken;
	static Point[] sel;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		sel = new Point[M];
		chicken = new ArrayList<>();
		min = 987654321;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int curr = Integer.parseInt(st.nextToken());
				if (curr == 2) {
					chicken.add(new Point(i, j));
					continue;
				}
				map[i][j] = curr;
			}
		}
		
		size = chicken.size();
		comb(0, 0);
		System.out.println(min);
	}

	private static void comb(int idx, int sidx) {
		if (sidx == M) {
			min = Math.min(min, calculate(sel));
			
			return;
		}
		
		if (idx == size) return;
		sel[sidx] = chicken.get(idx);
		comb(idx + 1, sidx + 1);
		comb(idx + 1, sidx);
	}

	private static int calculate(Point[] sel) {
		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int distance = 987654321;
				if (map[i][j] == 1) {
					for (Point p : sel) {
						int d = Math.abs(i - p.x) + Math.abs(j - p.y);
						distance = Math.min(distance, d);
					}
					ans += distance;
				}
			}
		}
		return ans;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(in.readLine()); // n, m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		init(n);

		for (int i = 1; i <= m; i++) {
			st = new StringTokenizer(in.readLine()); // a, b

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (!union(a, b)) { // 사이클이면
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}

	private static void init(int n) {
		p = new int[n];
		for (int i = 0; i < n; i++) {
			p[i] = i;
		}
	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			p[aRoot] = bRoot;
			return true;
		}
		return false;
	}

	private static int find(int x) {
		if (p[x] == x) return x;
		return p[x] = find(p[x]);
	}
}

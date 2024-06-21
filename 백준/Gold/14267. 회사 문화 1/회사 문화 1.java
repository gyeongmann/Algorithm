import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
 * 처음에 틀린 이유 - 여러 부하 직원들이 한 사람을 상사로 둘 수 있다(중복)
 */
public class Main {
	static List<Integer>[] kids; // 부하직원
	static int[] point; // 점수
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(in.readLine()); // n, m
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		kids = new ArrayList[n + 1];
		
		for (int i = 1; i <= n; i++) {
			kids[i] = new ArrayList<>();
		}
		st = new StringTokenizer(in.readLine()); // 상사 정보
		for (int kid = 1; kid <= n; kid++) {
			int parent = Integer.parseInt(st.nextToken());
			if (parent > 0) {
				kids[parent].add(kid);
			}
		}
		
		point = new int[n + 1];
		// 누적합 사용하면 된다!
		for (int line = 0; line < m; line++) {
			st = new StringTokenizer(in.readLine()); // i, w
			
			int i = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			point[i] += w;
		}
		
		cumulativeSum(1, kids);
		for (int i = 1; i <= n; i++) {
			System.out.print(point[i] + " ");
		}
	}
	private static void cumulativeSum(int curr, List<Integer>[] adj) {
		for (int nxt : adj[curr]) {
			point[nxt] += point[curr];
			cumulativeSum(nxt, adj);
		}
	}
}

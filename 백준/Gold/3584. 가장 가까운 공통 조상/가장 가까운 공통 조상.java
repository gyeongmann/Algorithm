import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, root;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			p = new int[N + 1];
			
			for (int i = 0; i < N - 1; i++) {
				st = new StringTokenizer(in.readLine());
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());
				
				p[child] = parent;
			}
			
			root = 0;
			for (int i = 1; i <= N; i++) {
				if (p[i] == 0) {
					root = i;
					break;
				}
			}
			
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int depthA = findDepth(a);
			int depthB = findDepth(b);
			
			// depth가 큰 걸 차이만큼 올린다
			if (depthA > depthB) {
				for (int i = 0; i < depthA - depthB; i++) { // A를 올려
					a = p[a];
				}
			} else if (depthB > depthA) {
				for (int i = 0; i < depthB - depthA; i++) { // B를 올려
					b = p[b];
				}
				
			}
			
			if (a == b) { // 올라왔는데 같아지면
//				System.out.println(a);
				sb.append(a + "\n");
				continue;
			}
			
			while (p[a] != p[b]) {
				a = p[a];
				b = p[b];
			}
			
//			System.out.println(p[a]);
			sb.append(p[a] + "\n");
		} // tc
		System.out.println(sb);
	}

	private static int findDepth(int a) {
		int curr = a;
		int depth = 0;
		while (p[curr] != 0) {
			depth++;
			curr = p[curr];
		}
		
		return depth;
	}

	private static void init() {
		for (int i = 1; i <= N; i++) {
			p[i] = i;
		}
	}
}

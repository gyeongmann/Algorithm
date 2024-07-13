import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(in.readLine());
		int[][] skyline = new int[N + 1][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			skyline[i][0] = x;
			skyline[i][1] = y;
		}
		skyline[N][0] = 1_000_001;
		boolean[] vis = new boolean[N + 1];
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (vis[i]) continue;
			vis[i] = true;
			
			int curr = skyline[i][1];
			for (int j = i + 1; j <= N; j++) {
				if (curr > skyline[j][1]) {
//					System.out.println(i + " " + j + " " + Arrays.toString(skyline[j]));
					cnt++;
					break;
				} else if (curr == skyline[j][1]) {
					vis[j] = true;
				}
			}
		}
		
		System.out.println(cnt);
	}
}
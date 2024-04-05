import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // A, B배열의 개수 (1 <= N,M <= 20_000)
	static int[] A, B;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine()); // 첫줄
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			A = new int[N];
			B = new int[M];
			
			st = new StringTokenizer(in.readLine()); // 두번째줄
			for (int i = 0; i < N; i++) {
				A[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(in.readLine()); // 세번째줄
			for (int i = 0; i < M; i++) {
				B[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(A);
			Arrays.sort(B);
			
			int bPointer = 0, cnt = 0, ans = 0;
			for (int i = 0; i < N; i++) { // i: A의 포인터
				while (bPointer < M && A[i] > B[bPointer]) { // A > B인 경우
					bPointer++;
					cnt++;
				}
				
				ans += cnt;
			}
			
			System.out.println(ans);
		} // tc
	} // main
}

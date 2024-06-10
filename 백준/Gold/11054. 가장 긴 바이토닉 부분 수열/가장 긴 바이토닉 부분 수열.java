import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(in.readLine());
		
		int[] A = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] LIS = new int[N];
		for (int i = 0; i < N; i++) {
			LIS[i] = 1;
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					LIS[i] = Math.max(LIS[j] + 1, LIS[i]);
				}
			}
		}
		
		int[] LDS = new int[N];
		for (int i = N - 1; i >= 0; i--) {
			LDS[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (A[i] > A[j]) {
					LDS[i] = Math.max(LDS[j] + 1, LDS[i]);
				}
			}
		}
		
//		System.out.println(Arrays.toString(LIS));
//		System.out.println(Arrays.toString(LDS));
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, LIS[i] + LDS[i] - 1);
		}
		System.out.println(ans);
	}
}

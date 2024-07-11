import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		int[] skip = new int[L];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < L; i++) {
			skip[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(skip);
//		System.out.println(Arrays.toString(skip));
		int n = Integer.parseInt(br.readLine());
		
		int idx = 0;
		for (idx = 0; idx < L; idx++) {
			if (n < skip[idx]) {
//				System.out.println(idx);
				break;
			}
		}
		
		int ans = 0;
		int left = 1;
		int right = 1;
		if (idx == 0) {
			left = 0;
			right = skip[idx];
		} else {
			left = skip[idx - 1];
			right = skip[idx];
		}
		
		for (int i = left + 1; i <= n; i++) {
			for (int j = n; j < right; j++) {
				if (i != j) ans++;
			}
		}
		
		System.out.println(ans);
	}
}
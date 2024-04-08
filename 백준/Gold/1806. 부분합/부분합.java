import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int sum = arr[0];
		int right = 0;
		int min = 987654321;
		for (int left = 0; left < N; left++) {
			while (right < N && sum < S) {
				right++;
				if (right != N) sum += arr[right];
			}
			if (right == N) break;
			min = Math.min(min, right - left + 1);
			sum -= arr[left];
		}
		
		if (min == 987654321) {
			System.out.println(0);
			return;
		}
		System.out.println(min);
	}
}

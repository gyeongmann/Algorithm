import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine()); // 재료의 개수
		int M = Integer.parseInt(in.readLine()); // 목표 숫자
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] src = new int[N];
		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(src);
		
		int left = 0;
		int right = N - 1;
		
		int ans = 0;
		while (left < right) {
			int sum = src[left] + src[right];
			
			if (sum < M) left++;
			else if (sum > M) right--;
			else {
				left++;
				right--;
				ans++;
			}
		}
		
		System.out.println(ans);
	}
}

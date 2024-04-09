import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		
		int left = 0;
		int right = N - 1;
		int max = 0;
		while (left < right) {
			int cur = (right - left - 1) * Math.min(arr[left], arr[right]);
			max = Math.max(max, cur);
			if (arr[left] > arr[right]) right--;
			else left++;
		}
		
		System.out.println(max);
	}
}

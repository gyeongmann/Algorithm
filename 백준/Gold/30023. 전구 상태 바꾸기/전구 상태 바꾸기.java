import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int N, ans;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		String light = in.readLine();
		
		int[] lights = new int[N];
		int val = 0;
		for (int i = 0; i < N; i++) {
			char ch = light.charAt(i);
			if (ch == 'R') {
				val = 0;
			} else if (ch == 'G') {
				val = 1;
			} else if (ch == 'B') {
				val = 2;
			}
			lights[i] = val;
		}
		
		ans = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			setLight(i, lights);
		}
		
		if (ans == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(ans);
	}
	
	private static void setLight(int target, int[] arr) {
		int[] lights = Arrays.copyOf(arr, N);
		int cnt = 0;
//		System.out.println(Arrays.toString(lights));
		for (int i = 0; i < N - 2; i++) {
			if (lights[i] == target) continue;
			while (lights[i] != target) {
				click(i, lights);
				cnt++;
			}
//			System.out.println(Arrays.toString(lights));
		}
//		System.out.println("--------------------");
		
		if (check(lights, target)) {
			ans = Math.min(ans, cnt);
		}
	}

	private static boolean check(int[] lights, int target) {
		for (int i = 1; i <= 3; i++) {
			if (lights[N - i] != target) return false;
		}
		return true;
	}

	// 0 -> 1, 1 -> 2, 2 -> 0
	private static void click(int i, int[] lights) {
		for (int idx = 0; idx < 3; idx++) {
			lights[i + idx] = (lights[i + idx] + 1) % 3;
		}
	}
}

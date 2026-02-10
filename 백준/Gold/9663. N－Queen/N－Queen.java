import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		backTracking(new int[N], 0);
		System.out.println(answer);
	}

	static boolean backTracking(int[] track, int depth) {
		if (depth == N) {
			answer++;
			return true;
		}

		for (int i = 0; i < N; i++) {
			if (!isAvailable(track, depth, i)) {
				continue;
			}

			track[depth] = i;
			if (!backTracking(track, depth + 1)) {
				continue;
			}
		}

		return false;
	}

	static boolean isAvailable(int[] track, int depth, int col) {
		for (int row = 0; row < depth; row++) {
			if (track[row] == col || depth - row == Math.abs(track[row] - col)) {
				return false;
			}
		}

		return true;
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = y - x; // distance

			int max = (int)Math.sqrt(d);

			if (max * max == d) {
				sb.append(max * 2 - 1).append('\n');
			} else if (d <= max * max + max) {
				sb.append(max * 2).append('\n');
			} else {
				sb.append(max * 2 + 1).append('\n');
			}
		}

		System.out.print(sb);
	}
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String line;
		int[] arr = new int[3];
		while ((line = in.readLine()).charAt(0) != '0') {
			st = new StringTokenizer(line);
			for (int i = 0; i < 3; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);
			
			int aSquare = (int) Math.pow(arr[0], 2);
			int bSquare = (int) Math.pow(arr[1], 2);
			int cSquare = (int) Math.pow(arr[2], 2);
			if (cSquare == (aSquare + bSquare)) {
				sb.append("right").append('\n');
				continue;
			}
			sb.append("wrong").append('\n');
		}
		System.out.println(sb);
	}
}

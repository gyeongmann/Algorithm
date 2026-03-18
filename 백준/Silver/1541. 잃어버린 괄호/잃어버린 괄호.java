import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		Queue<String> q = new LinkedList<>();
		StringTokenizer st = new StringTokenizer(line, "-");
		while (st.hasMoreTokens()) {
			q.offer(st.nextToken());
		}

		int sum = calculateSum(q.poll());
		while (!q.isEmpty()) {
			String expr = q.poll();
			int curr = calculateSum(expr);
			sum -= curr;
		}

		System.out.println(sum);
	}

	private static int calculateSum(String expr) {
		int sum = 0;
		StringTokenizer st = new StringTokenizer(expr, "+");
		while (st.hasMoreTokens()) {
			sum += Integer.parseInt(st.nextToken());
		}
		return sum;
	}
}

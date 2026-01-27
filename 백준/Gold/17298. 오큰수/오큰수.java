import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Stack<int[]> stack = new Stack<>();
		stack.push(new int[] { 0, Integer.parseInt(st.nextToken()) });
		int[] answer = new int[N];
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (!stack.isEmpty() && stack.peek()[1] < num) {
				while (!stack.isEmpty() && stack.peek()[1] < num) {
					int[] top = stack.pop();
					answer[top[0]] = num;
				}
				stack.push(new int[] { i, num });
			} else {
				stack.push(new int[] { i, num });
			}
		}

		while (!stack.isEmpty()) {
			int[] top = stack.pop();
			answer[top[0]] = -1;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb.toString());
	}
}

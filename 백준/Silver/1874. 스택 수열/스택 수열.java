import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();

		int num = 1;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			int curr = Integer.parseInt(br.readLine());

			if (num < curr) {
				while (num != curr) {
					stack.push(num++);
					sb.append("+").append('\n');
				}
				stack.push(num++);
				sb.append("+").append('\n');
				stack.pop();
				sb.append("-").append('\n');
			} else if (num == curr) {
				stack.push(num++);
				sb.append("+").append('\n');
				stack.pop();
				sb.append("-").append('\n');
			} else if (!stack.isEmpty() && stack.peek() == curr) {
				stack.pop();
				sb.append("-").append('\n');
			} else {
				System.out.println("NO");
				return;
			}
		}

		System.out.println(sb.toString());
	}
}

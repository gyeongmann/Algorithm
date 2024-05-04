import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		char[] arr = line.toCharArray();
		
		Map<Character, Integer> priority = new HashMap<>();
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		
		Stack<Character> st = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++) {
			char ch = arr[i];
			
			// 숫자면
			if (isNumber(ch)) {
				sb.append(ch);
				continue;
			}
			// 숫자가 아니면
			// 1. 여는 괄호이면 push
			// 2. 닫는 괄호이면 여는 괄호 나올 때까지 pop
			// 3. 연산자는 우선순위가 낮은 연산자를 만날 때까지 pop
			if (ch == '(') {
				st.push(ch);
			} else if (ch == ')') {
				while (st.peek() != '(') {
					sb.append(st.pop());
				}
				st.pop();
			} else {
				if (st.isEmpty()) {
					st.push(ch);
				} else {
					int topPrior;
					int currPrior = priority.get(ch);
					while (!st.isEmpty() && (topPrior = priority.get(st.peek())) >= currPrior) {
						sb.append(st.pop());
					}
					st.push(ch);
				}
			}
		}
		
		while (!st.isEmpty()) {
			sb.append(st.pop());
		}
		System.out.println(sb);
	}
	
	static boolean isNumber(char ch) {
		if (ch == '*' || ch == '/' || ch == '+' || ch == '-' || ch == '(' || ch == ')')
			return false;
		return true;
	}
}

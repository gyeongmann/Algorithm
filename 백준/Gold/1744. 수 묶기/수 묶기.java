import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> positivePq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> negativePq = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num > 1) {
				// 0보다 큰 수
				positivePq.add(num);
			} else if (num == 1) {
				one++;
			} else if (num == 0) {
				zero++;
			} else {
				negativePq.add(num);
			}
		}

		long answer = 0;
		while (positivePq.size() >= 2) {
			int a = positivePq.poll();
			int b = positivePq.poll();
			answer += a * b;
		}

		if (!positivePq.isEmpty()) {
			answer += positivePq.poll();
		}

		while (negativePq.size() >= 2) {
			int a = negativePq.poll();
			int b = negativePq.poll();
			answer += a * b;
		}

		if (!negativePq.isEmpty()) {
			if (zero == 0) {
				answer += negativePq.poll();
			}
		}
		
		answer += one;
		System.out.println(answer);
	}
}

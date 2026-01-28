import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> negativeQueue = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> positiveQueue = new PriorityQueue<>();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				boolean isNegativeEmpty = negativeQueue.isEmpty();
				boolean isPositiveEmpty = positiveQueue.isEmpty();

				if (isNegativeEmpty && isPositiveEmpty) {
					sb.append(0).append('\n');
				} else if (isNegativeEmpty && !isPositiveEmpty) {
					sb.append(positiveQueue.poll()).append('\n');
				} else if (!isNegativeEmpty && isPositiveEmpty) {
					sb.append(negativeQueue.poll()).append('\n');
				} else if (Math.abs(negativeQueue.peek()) <= Math.abs(positiveQueue.peek())) {
					sb.append(negativeQueue.poll()).append('\n');
				} else if (Math.abs(negativeQueue.peek()) > Math.abs(positiveQueue.peek())) {
					sb.append(positiveQueue.poll()).append('\n');
				}
			} else if (x < 0) {
				negativeQueue.add(x);
			} else if (x > 0) {
				positiveQueue.add(x);
			}
		}

		System.out.println(sb.toString());
	}
}

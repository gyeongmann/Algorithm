import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		
		PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
		}); // 최대 힙
		PriorityQueue<Integer> right = new PriorityQueue<>(); // 최소 힙
		
		for (int i = 0; i < N; i++) {
			int curr = Integer.parseInt(in.readLine());
			if (i % 2 == 0) { // left push
				left.add(curr);
			} else { // right push
				right.add(curr);
			}
			
			if (i >= 1 && left.peek() > right.peek()) {
				// swap
				int leftTop = left.poll();
				int rightTop = right.poll();
				left.add(rightTop);
				right.add(leftTop);
			}
			
			sb.append(left.peek()).append('\n');
		}
		
		System.out.println(sb);
	}
}

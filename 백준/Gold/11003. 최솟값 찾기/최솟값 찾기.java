import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] A = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int left = 0 - L + 1;

		Deque<int[]> deque = new ArrayDeque<>();
		deque.addLast(new int[] { 0, A[0] });

		StringBuilder sb = new StringBuilder();
		sb.append(A[0] + " ");
		for (int i = 1; i < N; i++) {
			left++;
			if (left > 0) {
				if (deque.peekFirst()[0] < left) {
					deque.removeFirst();
				}
			}

			int curr = A[i];
			while (!deque.isEmpty() && deque.peekLast()[1] >= curr) {
				deque.removeLast();
			}
			deque.addLast(new int[] { i, A[i] });

			sb.append(deque.peekFirst()[1] + " ");
		}

		System.out.println(sb.toString());
	}
}

import java.io.*;
import java.util.Arrays;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Node[] A = new Node[N];
		for (int i = 0; i < N; i++) {
			A[i] = new Node(i, Integer.parseInt(br.readLine()));
		}

		Arrays.sort(A);

		int answer = -1;
		for (int i = 0; i < N; i++) {
			Node curr = A[i];
			answer = Math.max(answer, curr.idx - i);
		}

		System.out.println(answer + 1);
	}

	private static class Node implements Comparable<Node> {

		int idx, value;

		public Node(int idx, int value) {
			this.idx = idx;
			this.value = value;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.value, o.value);
		}
	}
}

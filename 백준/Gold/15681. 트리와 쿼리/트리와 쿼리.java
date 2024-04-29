import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int idx;
		List<Node> child;

		public Node(int idx) {
			super();
			this.idx = idx;
			this.child = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", child=" + child + "]";
		}

	}

	static int N, R, Q;
	static int[] size;
	static List<Integer>[] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()); // 첫줄

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken()); // root
		Q = Integer.parseInt(st.nextToken());

		adj = new ArrayList[N + 1];
		size = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		Node root = new Node(R);
		makeTree(root, -1);
		countSubtreeNodes(root);

		for (int i = 0; i < Q; i++) {
			int idx = Integer.parseInt(in.readLine());
			System.out.println(size[idx]);
		}
	}

	private static void makeTree(Node node, int parent) {
		for (Integer i : adj[node.idx]) {
			if (i != parent) {
				Node child = new Node(i);
				node.child.add(child);
				makeTree(child, node.idx);
			}
		}
	}

	private static void countSubtreeNodes(Node node) {
		size[node.idx] = 1;
		for (Node ch : node.child) {
			countSubtreeNodes(ch);
			size[node.idx] += size[ch.idx];
		}
	}

}

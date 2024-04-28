import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		String id;
		Node left, right;

		public Node(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return "Node [id=" + id + ", left=" + left + ", right=" + right + "]";
		}

	}

	static Map<String, Node> tree;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		tree = new HashMap<>();
		int N = Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			String id = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();

			Node node = new Node(id);
			if (!tree.containsKey(id)) {
				tree.put(id, node);
			}
			node = tree.get(id);

			if (!tree.containsKey(left)) {
				tree.put(left, new Node(left));
			}
			if (!tree.containsKey(right)) {
				tree.put(right, new Node(right));
			}

			node.left = tree.get(left);
			node.right = tree.get(right);
		}

		Node root = tree.get("A");
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
	}

	private static void preorder(Node curr) {
		if (curr.id.equals(".")) return;
		System.out.print(curr.id);
		preorder(curr.left);
		preorder(curr.right);
	}

	private static void inorder(Node curr) {
		if (curr.id.equals(".")) return;
		inorder(curr.left);
		System.out.print(curr.id);
		inorder(curr.right);
	}
	
	private static void postorder(Node curr) {
		if (curr.id.equals(".")) return;
		postorder(curr.left);
		postorder(curr.right);
		System.out.print(curr.id);
	}
}

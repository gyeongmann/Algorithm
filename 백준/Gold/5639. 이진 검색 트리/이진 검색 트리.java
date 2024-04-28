import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static class Node {
		int id;
		Node left, right;
		
		public Node(int id) {
			super();
			this.id = id;
		}
		
		@Override
		public String toString() {
			return "Node [id=" + id + ", left=" + left + ", right=" + right + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		String line = in.readLine();
		int id = Integer.parseInt(line);
		Node root = new Node(id);
		
		while (true) {
			line = in.readLine();
			if (line == null || line.equals("")) break;
			id = Integer.parseInt(line);
			insert(new Node(id), root);
		}
		
		postOrder(root);
	}

	private static void insert(Node node, Node root) {
		if (node.id < root.id) {
			if (root.left != null) {
				insert(node, root.left);
				return;
			}
			root.left = node;
			return;
		}
		
		if (root.right != null) {
			insert(node, root.right);
			return;
		}
		root.right = node;
	}

	private static void postOrder(Node node) {
		if (node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.println(node.id);
	}
}

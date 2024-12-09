import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        List<Node> child;
        String name;

        public Node() {
            child = new ArrayList<>();
            this.name = "";
        }

        public Node(String name) {
            child = new ArrayList<>();
            this.name = name;
        }

        @Override
        public int compareTo(Node o) {
            return this.name.compareTo(o.name);
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node root = new Node("root");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            
            Node beforeNode = root;
            String curr = "";
            for (int j = 0; j < l; j++) {
                curr = st.nextToken();
                Node currNode = new Node();
                for (Node node : beforeNode.child) {
                    if (node.name.equals(curr)) {
                        currNode = node;
                        // System.out.println("currNode: " + currNode);
                    }
                }

                if (currNode.name.equals("")) { // 기존에 없는 node
                    currNode = new Node(curr);
                    beforeNode.child.add(currNode);
                }

                beforeNode = currNode;
            }
        }

        Collections.sort(root.child);
        for (Node node : root.child) {
            printNode(node, 0);
        }
    }

    static void printNode(Node curr, int depth) {
        for (int i = 0; i < depth; i++) {
            System.out.print("--");
        }
        System.out.println(curr.name);

        if (curr.child.size() == 0) return;
        Collections.sort(curr.child);
        for (Node next : curr.child) {
            printNode(next, depth+1);
        }
    }
}
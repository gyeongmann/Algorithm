import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        String query;
        Node leftUP, rightUp, leftDown, rightDown;

        public Node() {
        }

        public Node(String query) {
            this.query = query;
        }

        public void setLeftUP(Node leftUP) {
            this.leftUP = leftUP;
        }

        public void setRightUp(Node rightUp) {
            this.rightUp = rightUp;
        }

        public void setLeftDown(Node leftDown) {
            this.leftDown = leftDown;
        }

        public void setRightDown(Node rightDown) {
            this.rightDown = rightDown;
        }
    }

    static int N;
    static Node root;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        if (isWholeOne(board, 0, 0, N, N)) {
            System.out.println(1);
            return;
        } else if (isWholeZero(board, 0, 0, N, N)) {
            System.out.println(0);
            return;
        }

        root = new Node("");
        DFS(board, 0, 0, N, root);
        String answer = print(root);
        System.out.println(answer);
    }

    private static String print(Node node) {
        if (node == null || node.query == null) {  // query가 null인지 먼저 확인
            return "";
        }

        if (node.query.equals("1") || node.query.equals("0")) {
            return node.query;  // 값이 1 또는 0이면 바로 반환
        }

        // 사분면 출력
        String curr = "(";
        curr += print(node.leftUP);
        curr += print(node.rightUp);
        curr += print(node.leftDown);
        curr += print(node.rightDown);
        curr += ")";

        return curr;
    }

    private static void DFS(char[][] board, int i, int j, int size, Node root) {
        if (size == 1) {  // 기저 조건: 사이즈가 1일 때 노드에 값을 저장
            root.query = String.valueOf(board[i][j]);
            return;
        }

        int l = size / 2;

        // 좌상단 영역
        if (isWholeOne(board, i, j, i + l, j + l)) {
            root.setLeftUP(new Node("1"));
        } else if (isWholeZero(board, i, j, i + l, j + l)) {
            root.setLeftUP(new Node("0"));
        } else {
            root.setLeftUP(new Node("*"));
            DFS(board, i, j, l, root.leftUP);
        }

        // 우상단 영역
        if (isWholeOne(board, i, j + l, i + l, j + size)) {
            root.setRightUp(new Node("1"));
        } else if (isWholeZero(board, i, j + l, i + l, j + size)) {
            root.setRightUp(new Node("0"));
        } else {
            root.setRightUp(new Node("*"));
            DFS(board, i, j + l, l, root.rightUp);
        }

        // 좌하단 영역
        if (isWholeOne(board, i + l, j, i + size, j + l)) {
            root.setLeftDown(new Node("1"));
        } else if (isWholeZero(board, i + l, j, i + size, j + l)) {
            root.setLeftDown(new Node("0"));
        } else {
            root.setLeftDown(new Node("*"));
            DFS(board, i + l, j, l, root.leftDown);
        }

        // 우하단 영역
        if (isWholeOne(board, i + l, j + l, i + size, j + size)) {
            root.setRightDown(new Node("1"));
        } else if (isWholeZero(board, i + l, j + l, i + size, j + size)) {
            root.setRightDown(new Node("0"));
        } else {
            root.setRightDown(new Node("*"));
            DFS(board, i + l, j + l, l, root.rightDown);
        }
    }

    private static boolean isWholeOne(char[][] board, int i, int j, int k, int l) {
        for (int r = i; r < k; r++) {
            for (int c = j; c < l; c++) {
                if (board[r][c] == '0') return false;
            }
        }
        return true;
    }

    private static boolean isWholeZero(char[][] board, int i, int j, int k, int l) {
        for (int r = i; r < k; r++) {
            for (int c = j; c < l; c++) {
                if (board[r][c] == '1') return false;
            }
        }
        return true;
    }
}
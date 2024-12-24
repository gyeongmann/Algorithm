import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c, sum;
        public Node(int r, int c, int sum) {
            this.r = r;
            this.c = c;
            this.sum = sum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[R][C];
        for(int i = 0; i < R; i++) {
            String row = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        Deque<Node> deque = new ArrayDeque<>();
        deque.offer(new Node(0, 0, map[0][0]));
        boolean[][] vis = new boolean[R][C];
        vis[0][0] = true;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!deque.isEmpty()) {
            Node curr = deque.pollFirst();
            int r = curr.r;
            int c = curr.c;
            int sum = curr.sum;

            if (r == R-1 && c == C-1) {
                System.out.println(sum);
                return;
            }

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(vis[nr][nc]) continue;

                if(map[nr][nc] == 0) {
                    deque.offerFirst(new Node(nr, nc, sum));
                } else {
                    deque.offerLast(new Node(nr, nc, sum+1));
                }
                vis[nr][nc] = true;
            }
        }
    }
}
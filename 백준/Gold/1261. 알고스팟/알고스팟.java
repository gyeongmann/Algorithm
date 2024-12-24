import java.io.*;
import java.util.*;

public class Main {
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

        Deque<int[]> deque = new ArrayDeque<>();
        deque.offer(new int[] {0, 0, map[0][0]});
        boolean[][] vis = new boolean[R][C];
        vis[0][0] = true;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        while(!deque.isEmpty()) {
            int[] curr = deque.pollFirst();
            int r = curr[0];
            int c = curr[1];
            int sum = curr[2];

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
                    deque.offerFirst(new int[] {nr, nc, sum});
                } else {
                    deque.offerLast(new int[] {nr, nc, sum+1});
                }
                vis[nr][nc] = true;
            }
        }
    }
}
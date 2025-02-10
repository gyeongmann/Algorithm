import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = { 1, 0, -1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int all = 0;
        int[][] map = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int curr = Integer.parseInt(st.nextToken());
                map[r][c] = curr;
                if (curr == 1)
                    all++;
            }
        }

        // for (int[] row : map) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        int ans = 0;
        while (all > 0) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] vis = new boolean[N][M];
            int[][] count = new int[N][M];
            q.offer(new int[] { 0, 0 });
            vis[0][0] = true;
            while (!q.isEmpty()) {
                int[] curr = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = curr[0] + dr[i];
                    int nc = curr[1] + dc[i];
                    if (nr < 0 || nc < 0 || nr >= N || nc >= M)
                        continue;
                    if (vis[nr][nc])
                        continue;
                    if (map[nr][nc] == 1) {
                        count[nr][nc]++;
                    } else {
                        vis[nr][nc] = true;
                        q.offer(new int[] { nr, nc });
                    }
                }
            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < M; c++) {
                    if (count[r][c] >= 2) {
                        map[r][c] = 0;
                        all--;
                    }
                }
            }

            ans++;
        }
        System.out.println(ans);
    }
}
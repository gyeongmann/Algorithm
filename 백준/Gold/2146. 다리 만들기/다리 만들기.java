import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 1. 섬 분류하기
        int idx = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[N][N];
        int[][] outline = new int[N][N];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (map[r][c] == 0 || vis[r][c]) continue;
                idx++;

                q.offer(new int[] {r, c});
                vis[r][c] = true;
                map[r][c] = idx;
                while (!q.isEmpty()) {
                    int[] curr = q.poll();
                    for (int i = 0; i < 4; i++) {
                        int nr = curr[0] + dr[i];
                        int nc = curr[1] + dc[i];
                        if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                        if (vis[nr][nc]) continue;
                        if (map[nr][nc] == 0) {
                            outline[curr[0]][curr[1]] = idx;
                            continue;
                        }
                        map[nr][nc] = idx;
                        q.offer(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
        }

        // 2. 테두리에서 BFS해서 다른 섬 나오는 경우 depth의 최소값
        int answer = 10000;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (outline[r][c] > 0) { // 테두리일 때
                    q = new LinkedList<>();
                    vis = new boolean[N][N];

                    int currIdx = outline[r][c];
                    q.offer(new int[] {r, c});
                    vis[r][c] = true;
                    int depth = 0;
                    bfs: while (!q.isEmpty()) {
                        int size = q.size();
                        depth++;
                        for (int i = 0; i < size; i++) {
                            int[] curr = q.poll();

                            for (int dir = 0; dir < 4; dir++) {
                                int nr = curr[0] + dr[dir];
                                int nc = curr[1] + dc[dir];
                                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                                if (vis[nr][nc]) continue;
                                if (map[nr][nc] == currIdx) continue;
                                if (map[nr][nc] > 0 && map[nr][nc] != currIdx) {
                                    answer = Math.min(answer, depth-1);
                                    break bfs;
                                }

                                q.offer(new int[] {nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }

        System.out.println(answer);

    }
}
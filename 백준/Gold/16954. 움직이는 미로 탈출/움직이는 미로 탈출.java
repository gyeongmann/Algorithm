import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map = new char[8][8];
    static boolean vis[][];
    static int[] dr = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] dc = {0, -1, -1, 0, 1, 1, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 8; i++) {
            String row = br.readLine();
            for (int j = 0; j < 8; j++) {
                map[i][j] = row.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {7, 0});
        int depth = 0;
        
        while (!q.isEmpty()) {
            if (depth > 0) moveWall(map);
            if (!foundWall()) {
                System.out.println(1);
                return;
            }
            vis = new boolean[8][8];
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                if (r == 0 && c == 7) {
                    System.out.println(1);
                    return;
                }
                if (map[r][c] == '#') continue;

                for (int dir = 0; dir < 9; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (nr < 0 || nc < 0 || nr >= 8 || nc >= 8) continue;
                    if (vis[nr][nc]) continue;
                    if (map[nr][nc] == '.') {
                        q.offer(new int[] {nr, nc});
                        vis[nr][nc] = true;
                    }
                }
            }
            depth++;
        }
        System.out.println(0);
    }

    static void moveWall(char[][] map) {
        for (int i = 7; i > 0; i--) {
            map[i] = map[i-1];
        }
        map[0] = new char[] {'.', '.', '.', '.', '.', '.', '.', '.'};
    }

    static boolean foundWall() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (map[i][j] == '#')
                    return true;
            }
        }
        return false;
    }
}
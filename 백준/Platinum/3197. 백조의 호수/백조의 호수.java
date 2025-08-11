import java.io.*;
import java.util.*;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] swanVisited;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static Deque<int[]> waterQ = new ArrayDeque<>();
    static Deque<int[]> nextWaterQ = new ArrayDeque<>();
    static Deque<int[]> swanQ = new ArrayDeque<>();
    static Deque<int[]> nextSwanQ = new ArrayDeque<>();

    static int[] swan1, swan2;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        List<int[]> swans = new ArrayList<>(2);

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                char ch = line.charAt(c);
                map[r][c] = ch;
                if (ch != 'X') {
                    // 현재 물(또는 백조 위치)은 물 큐에 넣는다
                    waterQ.offer(new int[]{r, c});
                }
                if (ch == 'L') {
                    swans.add(new int[]{r, c});
                }
            }
        }

        swan1 = swans.get(0);
        swan2 = swans.get(1);

        // 백조 시작점 처리: 'L'을 물처럼 간주
        swanVisited = new boolean[R][C];
        swanQ.offer(swan1);
        swanVisited[swan1[0]][swan1[1]] = true;
        map[swan1[0]][swan1[1]] = '.';
        map[swan2[0]][swan2[1]] = '.'; // 도착점도 물로

        int days = 0;
        while (true) {
            if (moveSwans()) { // 오늘 물로 도달 가능?
                System.out.println(days);
                return;
            }
            melt(); // 물을 한 격자층 확장(얼음 녹이기)
            // 내일로 큐 교체
            swanQ = nextSwanQ; nextSwanQ = new ArrayDeque<>();
            waterQ = nextWaterQ; nextWaterQ = new ArrayDeque<>();
            days++;
        }
    }

    // 백조 이동 BFS: 물은 즉시 이동, 얼음은 내일 후보로
    static boolean moveSwans() {
        // for (char[] row : map) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println();
        while (!swanQ.isEmpty()) {
            int[] cur = swanQ.poll();
            int r = cur[0], c = cur[1];
            if (r == swan2[0] && c == swan2[1]) return true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (swanVisited[nr][nc]) continue;
                swanVisited[nr][nc] = true;
                if (map[nr][nc] == '.') {
                    // 지금 바로 갈 수 있는 물
                    swanQ.offer(new int[]{nr, nc});
                } else if (map[nr][nc] == 'X') {
                    // 얼음이면 내일 녹고 나서 이동
                    nextSwanQ.offer(new int[]{nr, nc});
                }
            }
        }
        return false;
    }

    // 물 확장 BFS: 현재 물의 경계에 있는 얼음을 녹여 내일의 물로 만든다
    static void melt() {
        while (!waterQ.isEmpty()) {
            int[] cur = waterQ.poll();
            int r = cur[0], c = cur[1];
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == 'X') {
                    map[nr][nc] = '.';          // 얼음 → 물
                    nextWaterQ.offer(new int[]{nr, nc}); // 내일의 물 경계
                }
            }
        }
    }
}

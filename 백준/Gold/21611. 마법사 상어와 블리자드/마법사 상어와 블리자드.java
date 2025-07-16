import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static int[][] idxMap;
    static int[] boomCount = new int[4];

    static int[] spiralDr = {0, 1, 0, -1}; // 우 하 좌 상
    static int[] blizzardDr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] blizzardDc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        idxMap = new int[N][N];
        arr = new int[N * N];

        // 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeSpiralIdxMap();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[idxMap[i][j]] = map[i][j];
            }
        }

        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            castBlizzard(d, s);
            move();
            while (explode()) move();
            transform();
        }

        System.out.println(boomCount[1] + 2 * boomCount[2] + 3 * boomCount[3]);
    }

    static void makeSpiralIdxMap() {
        int r = N / 2, c = N / 2;
        int idx = 1, len = 1, dir = 0;
        while (true) {
            for (int d = 0; d < 2; d++) {
                for (int i = 0; i < len; i++) {
                    r += spiralDr[dir];
                    c += spiralDr[(dir + 3) % 4];
                    if (r < 0 || c < 0 || r >= N || c >= N) return;
                    idxMap[r][c] = idx++;
                }
                dir = (dir + 1) % 4;
            }
            len++;
        }
    }

    static void castBlizzard(int d, int s) {
        int r = N / 2, c = N / 2;
        for (int i = 1; i <= s; i++) {
            int nr = r + blizzardDr[d] * i;
            int nc = c + blizzardDc[d] * i;
            arr[idxMap[nr][nc]] = 0;
        }
    }

    static void move() {
        int[] temp = new int[N * N];
        int t = 1;
        for (int i = 1; i < N * N; i++) {
            if (arr[i] != 0) temp[t++] = arr[i];
        }
        arr = temp;
    }

    static boolean explode() {
        boolean exploded = false;
        int before = arr[1], count = 1;

        for (int i = 2; i < N * N; i++) {
            if (arr[i] == before && before != 0) {
                count++;
            } else {
                if (count >= 4) {
                    for (int j = i - 1; j >= i - count; j--) arr[j] = 0;
                    boomCount[before] += count;
                    exploded = true;
                }
                before = arr[i];
                count = 1;
            }
        }

        if (count >= 4) {
            for (int j = N * N - 1; j >= N * N - count; j--) arr[j] = 0;
            boomCount[before] += count;
            exploded = true;
        }

        return exploded;
    }

    static void transform() {
        List<Integer> list = new ArrayList<>();
        int before = arr[1], count = 1;

        for (int i = 2; i < N * N; i++) {
            if (arr[i] == before && before != 0) {
                count++;
            } else {
                if (before != 0) {
                    list.add(count);
                    list.add(before);
                }
                before = arr[i];
                count = 1;
            }
        }

        int[] temp = new int[N * N];
        int idx = 1;
        for (int i = 0; i < list.size() && idx < N * N; i++) {
            temp[idx++] = list.get(i);
        }
        arr = temp;
    }
}

import java.util.*;
import java.io.*;

public class Main {
    static boolean[] vis;
    static int[][][] wheel = new int[5][3][3];
    static int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        for (int i = 1; i <= 4; i++) {
            String line = br.readLine();
            int r = 1; int c = 1;
            for (int j = 0; j < 8; j++) {
                int nr = r + dr[j];
                int nc = c + dc[j];
                wheel[i][nr][nc] = line.charAt(j) - '0';
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            vis = new boolean[5];
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            spin(idx, dir);
        }

        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            int start = wheel[i][1+dr[0]][1+dc[0]];
            if (start == 1) {
                answer += (int) Math.pow(2, i-1);
            }
        }

        System.out.println(answer);
    }

    static void spin(int idx, int dir) {
        if (vis[idx]) return;
        vis[idx] = true;
        if (idx + 1 <= 4 && wheel[idx][1][2] != wheel[idx+1][1][0]) {
            spin(idx+1, -1*dir);
        }

        if (idx - 1 >= 1 && wheel[idx][1][0] != wheel[idx-1][1][2]) {
            spin(idx-1, -1*dir);
        }

        if (dir == 1) { // 시계
            int r = 1; int c = 1;
            int start = wheel[idx][r+dr[0]][c+dc[0]]; // 12시 방향
            for (int i = 7; i > 0; i--) {
                int curr = r + dr[i];
                int curc = c + dc[i];

                int nr = r + dr[(i+1)%8];
                int nc = c + dc[(i+1)%8];
                wheel[idx][nr][nc] = wheel[idx][curr][curc];
            }
            wheel[idx][0][2] = start;
        } else if (dir == -1) { // 반시계
            int r = 1; int c = 1;
            int start = wheel[idx][r+dr[0]][c+dc[0]]; // 12시 방향
            for (int i = 1; i < 8; i++) {
                int curr = r + dr[i];
                int curc = c + dc[i];

                int nr = r + dr[i-1];
                int nc = c + dc[i-1];
                wheel[idx][nr][nc] = wheel[idx][curr][curc];
            }
            wheel[idx][0][0] = start;
        }
    }
}
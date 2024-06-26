import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * N14500_테트로미노
 */
public class Main {

    static int[] filter1 = { 0, 0, 1, 1, 2, 2 };
    static int[] filter2 = { 0, 1, 0, 1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine()); // N, M
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;

        // for (int[] row : board) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        // 2x2 Square
        int[][] square = new int[N - 1][M - 1];
        for (int r = 0; r < N - 1; r++) {
            for (int c = 0; c < M - 1; c++) {
                square[r][c] = board[r][c] + board[r + 1][c] + board[r][c + 1] + board[r + 1][c + 1];
                ans = Math.max(ans, square[r][c]);
            }
        }

        // for (int[] row : square) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        // 4x1 Stick
        int[][] stick1 = new int[N - 3][M];
        for (int r = 0; r < N - 3; r++) {
            for (int c = 0; c < M; c++) {
                stick1[r][c] = board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 3][c];
                ans = Math.max(ans, stick1[r][c]);
            }
        }
        // for (int[] row : stick1) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        // 1x4 Stick
        int[][] stick2 = new int[N][M - 3];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M - 3; c++) {
                stick2[r][c] = board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r][c + 3];
                ans = Math.max(ans, stick2[r][c]);
            }
        }
        // for (int[] row : stick2) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        // 3x2 rectangle
        int[][] rect1 = new int[N - 2][M - 1];
        for (int r = 0; r < N - 2; r++) {
            int max = 0;
            for (int c = 0; c < M - 1; c++) {
                int rect = board[r][c] + board[r][c + 1]
                        + board[r + 1][c] + board[r + 1][c + 1]
                        + board[r + 2][c] + board[r + 2][c + 1];

                /*
                 * static int[] filter1 = { 0, 0, 1, 1, 2, 2 };
                 * static int[] filter2 = { 0, 1, 0, 1, 0, 1 };
                 */
                max = Math.max(max,
                        rect - board[r + filter1[0]][c + filter2[0]] - board[r + filter1[2]][c + filter2[2]]);
                max = Math.max(max,
                        rect - board[r + filter1[0]][c + filter2[0]] - board[r + filter1[4]][c + filter2[4]]);
                max = Math.max(max,
                        rect - board[r + filter1[0]][c + filter2[0]] - board[r + filter1[5]][c + filter2[5]]);
                max = Math.max(max,
                        rect - board[r + filter1[1]][c + filter2[1]] - board[r + filter1[3]][c + filter2[3]]);
                max = Math.max(max,
                        rect - board[r + filter1[1]][c + filter2[1]] - board[r + filter1[4]][c + filter2[4]]);
                max = Math.max(max,
                        rect - board[r + filter1[1]][c + filter2[1]] - board[r + filter1[5]][c + filter2[5]]);
                max = Math.max(max,
                        rect - board[r + filter1[2]][c + filter2[2]] - board[r + filter1[4]][c + filter2[4]]);
                max = Math.max(max,
                        rect - board[r + filter1[3]][c + filter2[3]] - board[r + filter1[5]][c + filter2[5]]);

                rect1[r][c] = max;
                ans = Math.max(ans, rect1[r][c]);
            }
        }
        // for (int[] row : rect1) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();

        // 2x3 rectangle
        int[][] rect2 = new int[N - 1][M - 2];
        for (int r = 0; r < N - 1; r++) {
            int max = 0;
            for (int c = 0; c < M - 2; c++) {
                int rect = board[r][c] + board[r][c + 1] + board[r][c + 2]
                        + board[r + 1][c] + board[r + 1][c + 1] + board[r + 1][c + 2];

                /*
                 * static int[] filter2 = { 0, 1, 0, 1, 0, 1 };
                 * static int[] filter1 = { 0, 0, 1, 1, 2, 2 };
                 */
                max = Math.max(max,
                        rect - board[r + filter2[0]][c + filter1[0]] - board[r + filter2[2]][c + filter1[2]]);
                max = Math.max(max,
                        rect - board[r + filter2[0]][c + filter1[0]] - board[r + filter2[4]][c + filter1[4]]);
                max = Math.max(max,
                        rect - board[r + filter2[0]][c + filter1[0]] - board[r + filter2[5]][c + filter1[5]]);
                max = Math.max(max,
                        rect - board[r + filter2[1]][c + filter1[1]] - board[r + filter2[3]][c + filter1[3]]);
                max = Math.max(max,
                        rect - board[r + filter2[1]][c + filter1[1]] - board[r + filter2[4]][c + filter1[4]]);
                max = Math.max(max,
                        rect - board[r + filter2[1]][c + filter1[1]] - board[r + filter2[5]][c + filter1[5]]);
                max = Math.max(max,
                        rect - board[r + filter2[2]][c + filter1[2]] - board[r + filter2[4]][c + filter1[4]]);
                max = Math.max(max,
                        rect - board[r + filter2[3]][c + filter1[3]] - board[r + filter2[5]][c + filter1[5]]);

                rect2[r][c] = max;
                ans = Math.max(ans, rect2[r][c]);
            }
        }
        // for (int[] row : rect2) {
        // System.out.println(Arrays.toString(row));
        // }
        // System.out.println();
        System.out.println(ans);
    }
}
import java.util.*;
import java.io.*;

public class Main {

    static int N, M, R;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (R-- > 0) {
            int op = Integer.parseInt(st.nextToken());
            processOperation(op);
        }

        printMap();
    }

    static void processOperation(int op) {
        if (op == 1) flipVertical();
        else if (op == 2) flipHorizontal();
        else if (op == 3) rotateRight();
        else if (op == 4) rotateLeft();
        else if (op == 5) moveClockwise();
        else if (op == 6) moveCounterClockwise();
    }

    static void flipVertical() {
        for (int i = 0; i < N / 2; i++) {
            int[] temp = map[i];
            map[i] = map[N - 1 - i];
            map[N - 1 - i] = temp;
        }
    }

    static void flipHorizontal() {
        for (int i = 0; i < N; i++) {
            for (int j = 0, k = M - 1; j < k; j++, k--) {
                int temp = map[i][j];
                map[i][j] = map[i][k];
                map[i][k] = temp;
            }
        }
    }

    static void rotateRight() {
        int[][] newMap = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[j][N - 1 - i] = map[i][j];
            }
        }
        swapDimensions(newMap);
    }

    static void rotateLeft() {
        int[][] newMap = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newMap[M - 1 - j][i] = map[i][j];
            }
        }
        swapDimensions(newMap);
    }

    static void moveClockwise() {
        int halfN = N / 2, halfM = M / 2;
        int[][] newMap = new int[N][M];

        // 1 → 2
        copyBlock(newMap, 0, halfM, 0, 0, halfN, halfM);
        // 2 → 3
        copyBlock(newMap, halfN, halfM, 0, halfM, halfN, halfM);
        // 3 → 4
        copyBlock(newMap, halfN, 0, halfN, halfM, halfN, halfM);
        // 4 → 1
        copyBlock(newMap, 0, 0, halfN, 0, halfN, halfM);

        map = newMap;
    }

    static void moveCounterClockwise() {
        int halfN = N / 2, halfM = M / 2;
        int[][] newMap = new int[N][M];

        // 1 → 4
        copyBlock(newMap, halfN, 0, 0, 0, halfN, halfM);
        // 4 → 3
        copyBlock(newMap, halfN, halfM, halfN, 0, halfN, halfM);
        // 3 → 2
        copyBlock(newMap, 0, halfM, halfN, halfM, halfN, halfM);
        // 2 → 1
        copyBlock(newMap, 0, 0, 0, halfM, halfN, halfM);

        map = newMap;
    }

    static void copyBlock(int[][] newMap, int toRow, int toCol, int fromRow, int fromCol, int rowSize, int colSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                newMap[toRow + i][toCol + j] = map[fromRow + i][fromCol + j];
            }
        }
    }

    static void swapDimensions(int[][] newMap) {
        int temp = N;
        N = M;
        M = temp;
        map = newMap;
    }

    static void printMap() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

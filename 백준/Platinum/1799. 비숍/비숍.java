import java.util.*;
import java.io.*;

public class Main {
    static List<int[]> white = new ArrayList<>();
    static List<int[]> black = new ArrayList<>();
    static List<int[]> visWhite = new ArrayList<>();
    static List<int[]> visBlack = new ArrayList<>();
    static int whiteCnt, blackCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == 1) {
                    if ((i + j) % 2 == 0) {
                        white.add(new int[] { i, j });
                    } else {
                        black.add(new int[] { i, j });
                    }
                }
            }
        }

        dfsWhite(0);
        dfsBlack(0);
        System.out.println(whiteCnt + blackCnt);
    }

    private static void dfsWhite(int i) {
        if (i == white.size())
            return;
        int[] nPoint = white.get(i);
        for (int[] p : visWhite) {
            if (isOverlapped(p, nPoint)) {
                dfsWhite(i + 1);
                return;
            }
        }

        visWhite.add(nPoint);
        whiteCnt = Math.max(whiteCnt, visWhite.size());
        dfsWhite(i + 1);
        visWhite.remove(nPoint);
        dfsWhite(i + 1);
        whiteCnt = Math.max(whiteCnt, visWhite.size());
    }

    private static void dfsBlack(int i) {
        if (i == black.size())
            return;
        int[] nPoint = black.get(i);
        for (int[] p : visBlack) {
            if (isOverlapped(p, nPoint)) {
                dfsBlack(i + 1);
                return;
            }
        }

        visBlack.add(nPoint);
        blackCnt = Math.max(blackCnt, visBlack.size());
        dfsBlack(i + 1);
        visBlack.remove(nPoint);
        dfsBlack(i + 1);
        blackCnt = Math.max(blackCnt, visBlack.size());
    }

    private static boolean isOverlapped(int[] a, int[] b) {
        int x1 = a[0];
        int y1 = a[1];
        int x2 = b[0];
        int y2 = b[1];

        return (x1 - x2 == y1 - y2) || (x1 - x2 == y2 - y1);
    }
}
import java.util.*;
import java.io.*;

public class Main {
    static int n, num, cnt;
    static int[] result;
    static boolean[] vis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        result = new int[2 * n + 1];
        num = y - x - 1;
        result[x] = num;
        result[y] = num;

        vis = new boolean[n + 1];
        backTracking(1);
        System.out.println(cnt);
    }

    private static void backTracking(int idx) {
        if (idx == 2 * n) {
            cnt++;
            return;
        }

        if (result[idx] == 0) {
            for (int i = 1; i <= n; i++) {
                if (i == num)
                    continue;
                if (vis[i])
                    continue;
                int next = idx + i + 1;
                if (next <= 2 * n && result[next] == 0) {
                    result[idx] = i;
                    result[next] = i;
                    vis[i] = true;
                    backTracking(idx + 1);
                    result[idx] = 0;
                    result[next] = 0;
                    vis[i] = false;
                }
            }
        } else {
            backTracking(idx + 1);
        }
    }
}
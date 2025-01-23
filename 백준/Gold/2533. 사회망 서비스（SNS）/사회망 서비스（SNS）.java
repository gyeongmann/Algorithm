import java.util.*;
import java.io.*;

public class Main {

    static List<Integer>[] adj;
    static boolean[] vis;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        vis = new boolean[N + 1];
        dp = new int[N + 1][2];
        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[b].add(a);
            adj[a].add(b);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    private static void dfs(int i) {
        vis[i] = true;
        dp[i][1] = 1;

        for (int ch : adj[i]) {
            if (vis[ch])
                continue;
            dfs(ch);
            dp[i][0] += dp[ch][1];
            dp[i][1] += Math.min(dp[ch][0], dp[ch][1]);
        }
    }
}
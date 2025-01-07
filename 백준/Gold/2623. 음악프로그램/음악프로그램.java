import java.util.*;
import java.io.*;

public class Main {
    static List<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int[] degree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int before = Integer.parseInt(st.nextToken());
            for (int j = 1; j < num; j++) {
                int curr = Integer.parseInt(st.nextToken());
                adj[before].add(curr);
                degree[curr]++;
                before = curr;
            }
        }

        // cycle detection
        boolean[] recur = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            boolean[] vis = new boolean[N + 1];
            if (isCycle(i, vis, recur)) {
                System.out.println(0);
                return;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] vis = new boolean[N + 1];
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append('\n');
            vis[curr] = true;

            for (int next : adj[curr]) {
                degree[next]--;

                if (degree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (!vis[i]) {
                sb.append(i).append('\n');
            }
        }

        System.out.print(sb);
    }

    private static boolean isCycle(int curr, boolean[] vis, boolean[] recur) {
        vis[curr] = true;
        recur[curr] = true;

        for (int next : adj[curr]) {
            if (!vis[next] && isCycle(next, vis, recur)) {
                return true;
            } else if (recur[next]) {
                return true;
            }
        }

        recur[curr] = false;
        return false;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int v, h;

        public Edge(int v, int h) {
            this.v = v;
            this.h = h;
        }

        public int compareTo(Edge o) {
            return this.h - o.h;
        }
    }

    static int N;
    static int[][] d;
    static List<Edge>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        adj = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        d = new int[N + 1][N + 1];
        for (int[] row : d) {
            Arrays.fill(row, 987654321);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            adj[u].add(new Edge(v, h));
        }

        for (int i = 1; i <= N; i++) {
            dijkstra(i);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (d[i][j] == 987654321) {
                    d[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(d[s][e]);
        }

    }

    static void dijkstra(int s) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[N + 1];
        pq.add(new Edge(s, 0));
        d[s][s] = 0;

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (vis[curr.v]) continue;
            vis[curr.v] = true;

            for (Edge next : adj[curr.v]) {
                int maxHeight = Math.max(curr.h, next.h);
                if (d[s][next.v] > maxHeight) {
                    d[s][next.v] = maxHeight;
                    pq.add(new Edge(next.v, maxHeight));
                }
            }
        }
    }
}
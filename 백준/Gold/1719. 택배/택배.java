import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int from, to, weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }

        public String toString() {
            return from + " " + to + " " + weight;
        }
    }

    static List<Edge>[] adj;
    static int[][] ans;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ans = new int[n+1][n+1];
        adj = new List[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            adj[a].add(new Edge(a, b, weight));
            adj[b].add(new Edge(b, a, weight));
        }

        for (int i = 1; i <= n; i++) {
            Dijkstra(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (ans[i][j] == 0) {
                    sb.append("- ");
                    continue;
                }
                sb.append(ans[i][j] + " ");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    static int[] p;
    static void Dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[n+1];
        int[] d = new int[n+1];
        p = new int[n+1];
        Arrays.fill(d, 987654321);
        Arrays.fill(p, -1);
        pq.offer(new Edge(0, start, 0));
        d[start] = 0;
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if(vis[curr.to]) continue;
            vis[curr.to] = true;
            
            for (Edge edge : adj[curr.to]) {
                if (vis[edge.to]) continue;
                if (d[edge.to] > d[curr.to] + edge.weight) {
                    d[edge.to] = d[curr.to] + edge.weight;
                    p[edge.to] = edge.from;
                    pq.offer(new Edge(curr.to, edge.to, d[edge.to]));
                }
            }
        }

        // System.out.println(Arrays.toString(d));
        for (int i = 1; i <= n; i++) {
            if (i == start) continue;
            if (p[i] == -1) continue;
            ans[start][i] = find(start, i);
        }
    }

    static int find(int start, int idx) {
        while (p[idx] != start) {
            idx = p[idx];
        }
        return idx;
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        public Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        List<Edge>[] adj = new List[N+1]; // N번 노드는 범위 밖
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            if (0 <= i - a[i]) {
                adj[i-a[i]].add(new Edge(i, b[i]));
            }

            if (i + a[i] < N) {
                adj[i+a[i]].add(new Edge(i, b[i]));
            }

            if (i - a[i] < 0 || i + a[i] >= N) {
                adj[N].add(new Edge(i, b[i]));
            }
        }

        long[] ans = new long[N+1];
        Arrays.fill(ans, Long.MAX_VALUE);

        // dijstra(N)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        ans[N] = 0;
        pq.add(new Edge(N, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (ans[curr.to] < curr.weight) continue;

            for (Edge e : adj[curr.to]) {
                if (ans[e.to] > ans[curr.to] + e.weight) {
                    ans[e.to] = ans[curr.to] + e.weight;
                    pq.add(new Edge(e.to, ans[e.to]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++)
            sb.append(ans[i]).append(' ');
        System.out.println(sb);
    }
}
import java.util.*;

class Solution {
    class Edge implements Comparable<Edge> {
        int to, cost;
        
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    
    final int INF = 987654321;
    int[][] adj;
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        
        adj = new int[N + 1][N + 1];
        
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                adj[i][j] = INF;
            }
        }
        
        for (int[] row : road) {
            int a = row[0];
            int b = row[1];
            int cost = row[2];
            
            if (adj[a][b] > cost) {
                adj[a][b] = cost;
                adj[b][a] = cost;
            }
        }
        
        int answer = dijkstra(N, K);
        System.out.println(Arrays.toString(dist));
        return answer;
    }
    
    private int dijkstra(int n, int k) {
        boolean[] vis = new boolean[n + 1];
        dist[1] = 0;
        
        int cnt = 0;
        
        for (int i = 1; i < n; i++) {
            int min = INF;
            int idx = -1;
            
            for (int to = 1; to <= n; to++) {
                if (!vis[to] && min > dist[to]) {
                    idx = to;
                    min = dist[to];
                    // System.out.println(min);
                }
            }
            
            if (idx == -1) break;
            
            vis[idx] = true;
            
            for (int j = 2; j <= n; j++) {
                if (dist[j] > dist[idx] + adj[idx][j]) {
                    dist[j] = dist[idx] + adj[idx][j];
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] <= k) {
                cnt++;
            }
        }
        // System.out.println(cnt);
        return cnt;
    } // dijstra
}
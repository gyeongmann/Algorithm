import java.util.*;

class Solution {
    
    int MAX_VALUE = 987654321;
    
    class Edge implements Comparable<Edge> {
        int idx, weight;
        
        public Edge() {}
        public Edge(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    
    List<Edge>[] adj;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        adj = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        
        for (int[] edge : fares) {
            int from = edge[0];
            int to = edge[1];
            int c = edge[2];
            
            adj[from].add(new Edge(to, c));
            adj[to].add(new Edge(from, c));
        }
        
        int[] dist = dijkstra(s, n);
        // System.out.println(Arrays.toString(dist));
        
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == MAX_VALUE) continue;
            int tmp = dist[i];
            int[] ndist = dijkstra(i, n);
            
            tmp += ndist[a];
            tmp += ndist[b];
            
            answer = Math.min(answer, tmp);
        }
        return answer;
    }
    
    private int[] dijkstra(int s, int n) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, MAX_VALUE);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(s, 0));
        dist[s] = 0;
        boolean[] vis = new boolean[n+1];
        
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (vis[e.idx]) continue;
            vis[e.idx] = true;
            
            for (Edge next : adj[e.idx]) {
                if (dist[e.idx] + next.weight < dist[next.idx]) {
                    dist[next.idx] = dist[e.idx] + next.weight;
                    pq.add(new Edge(next.idx, dist[next.idx]));
                }
            }
        }
        
        return dist;
    }
}
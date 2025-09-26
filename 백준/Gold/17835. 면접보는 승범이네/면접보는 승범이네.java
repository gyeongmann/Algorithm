import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to; long cost;
        
        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }
    
    static long inf = Long.MAX_VALUE;
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    List<Edge>[] adj = new List[N+1];
	    for (int i = 1; i <= N; i++) {
	        adj[i] = new ArrayList<>();
	    }
	    
	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int U = Integer.parseInt(st.nextToken());
	        int V = Integer.parseInt(st.nextToken());
	        int C = Integer.parseInt(st.nextToken());
	        
	        // 역방향으로
	        adj[V].add(new Edge(U, C));
	    }
	    
	    int[] interview = new int[K];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < K; i++) {
	        interview[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    long[] answer = new long[N+1];
	    Arrays.fill(answer, inf);
	    
	    
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        boolean[] vis = new boolean[N+1];
        long[] d = new long[N+1];
        Arrays.fill(d, inf);
        for (int t : interview) {
            pq.offer(new Edge(t, 0));
            d[t] = 0;
        }
        
        
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            if (vis[curr.to]) continue;
            if (curr.cost > d[curr.to]) continue;
            vis[curr.to] = true;
            
            List<Edge> currList = adj[curr.to];
            for (Edge next : currList) {
                if (d[next.to] > curr.cost + next.cost) {
                    d[next.to] = curr.cost + next.cost;
                    pq.offer(new Edge(next.to, d[next.to]));
                }
            }
        }
        
        for (int j = 0; j <= N; j++) {
            answer[j] = Math.min(answer[j], d[j]);
        }
	    
	    long max = 0;
	    int maxIdx = 0;
	    for (int i = 1; i <= N; i++) {
	        if (max < answer[i]) {
	            max = answer[i];
	            maxIdx = i;
	        }
	    }
	    System.out.println(maxIdx);
	    System.out.println(max);
	}
}

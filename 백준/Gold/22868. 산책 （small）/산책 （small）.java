import java.util.*;
import java.io.*;

public class Main {
    
    static class Node {
        int idx, depth;
        
        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
        
        public String toString() {
            return idx + ", " + depth;
        }
    }
    
    static int N, answer;
    static int[][] adj;
    static boolean[] vis;
    static int[] route;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    adj = new int[N+1][N+1];
	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        
	        adj[a][b] = 1;
	        adj[b][a] = 1;
	    }
	    
	    st = new StringTokenizer(br.readLine());
	    int S = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
	    vis = new boolean[N+1];
	    route = new int[N+1];
	    BFS(S, E);
	    
	    int before = route[E];
	    Arrays.fill(vis, false);
	    while (before != S) {
	        vis[before] = true;
	        before = route[before];
	    }
	    
	    BFS(E, S);
	    System.out.println(answer);
	}
	
	static void BFS(int S, int E) {
	    Queue<Node> q = new LinkedList<>();
	    q.offer(new Node(S, 0));
	    vis[S] = true;
	    
	    while (!q.isEmpty()) {
	        Node node = q.poll();
	        int curr = node.idx;
	        int depth = node.depth;
	        
	        if (curr == E) {
	            answer += depth;
	            return;
	        }
	        for (int nxt = 1; nxt <= N; nxt++) {
	            if (adj[curr][nxt] == 1 && !vis[nxt]) {
	                q.offer(new Node(nxt, depth+1));
	                route[nxt] = curr;
	                vis[nxt] = true;
	            }
	        }
	    }
	}
}

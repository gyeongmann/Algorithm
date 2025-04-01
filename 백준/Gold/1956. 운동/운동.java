import java.util.*;
import java.io.*;

public class Main {
    static final int INF = 987654321;
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int V = Integer.parseInt(st.nextToken());
	    int E = Integer.parseInt(st.nextToken());
	    
	    List<int[]>[] adj = new List[V+1];
	    for (int i = 1; i <= V; i++) {
	        adj[i] = new ArrayList<>();
	    }
	    
	    int[][] floyd = new int[V+1][V+1];
	    for (int[] row : floyd) {
	        Arrays.fill(row, INF);
	    }
	    
	    for (int i = 0; i < E; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
	        
	        floyd[a][b] = c;
	    }
	    
	    for (int k = 1; k <= V; k++) {
	        for (int a = 1; a <= V; a++) {
	            for (int b = 1; b <= V; b++) {
	                floyd[a][b] = Math.min(floyd[a][k] + floyd[k][b], floyd[a][b]);
	            }
	        }
	    }
	    
	    int answer = INF; 
	    for (int i = 1; i <= V; i++) {
	        answer = Math.min(answer, floyd[i][i]);
	    }
	    if (answer == INF) {
	        System.out.println(-1);
	        return;
	    }
	    System.out.println(answer);
	}
}

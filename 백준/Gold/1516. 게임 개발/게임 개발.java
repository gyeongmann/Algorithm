import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] inDegree = new int[N+1];
	    int[] dist = new int[N+1];
	    List<int[]>[] graph = new List[N+1]; // {to, cost}
	    for (int i = 1; i <= N; i++) {
	        graph[i] = new ArrayList<>();
	    }
	    
	    for (int i = 1; i <= N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int d = Integer.parseInt(st.nextToken());
	        dist[i] = d;
	        
	        while (true) {
	            int from = Integer.parseInt(st.nextToken());
	            if (from == -1) break;
	            
	            inDegree[i]++;
	            graph[from].add(new int[] {i, d});
	        }
	    }
	    
	    Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= N; i++) {
	        if (inDegree[i] == 0) q.offer(i);
	    }
	    
	    while (!q.isEmpty()) {
	        int curr = q.poll();
	        for (int[] edge : graph[curr]) {
	            int next = edge[0];
	            int cost = edge[1];
	            
	            dist[next] = Math.max(dist[next], dist[curr] + cost);
	            inDegree[next]--;
	            if (inDegree[next] == 0) q.offer(next);
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 1; i <= N; i++) {
	        sb.append(dist[i]).append('\n');
	    }
	    
	    System.out.println(sb.toString());
	}
}

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int N = Integer.parseInt(br.readLine());
	    
	    int[] degree = new int[N+1];
	    int[] cost = new int[N+1];
	    int[] dp = new int[N+1];
	    List<Integer>[] nextIdx = new List[N+1];
	    for (int i = 1; i <= N; i++) {
	        nextIdx[i] = new ArrayList<>();
	    }
	    
	    for (int i = 1; i <= N; i++) {
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int c = Integer.parseInt(st.nextToken());
	        dp[i] = cost[i] = c;
	        
	        while (true) {
	            int from = Integer.parseInt(st.nextToken());
	            if (from == -1) break;
	            
	            degree[i]++;
	            nextIdx[from].add(i);
	        }
	    }
	    
	    Queue<Integer> q = new LinkedList<>();
	    for (int i = 1; i <= N; i++) {
	        if (degree[i] == 0) q.offer(i);
	    }
	    
	    while (!q.isEmpty()) {
	        int curr = q.poll();
	        for (int next : nextIdx[curr]) {
	            dp[next] = Math.max(dp[next], dp[curr] + cost[next]);
	            degree[next]--;
	            if (degree[next] == 0) q.offer(next);
	        }
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 1; i <= N; i++) {
	        sb.append(dp[i]).append('\n');
	    }
	    
	    System.out.println(sb.toString());
	}
}

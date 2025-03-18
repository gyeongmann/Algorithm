import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int F = Integer.parseInt(st.nextToken());
	    int S = Integer.parseInt(st.nextToken());
	    int G = Integer.parseInt(st.nextToken());
	    int U = Integer.parseInt(st.nextToken());
	    int D = Integer.parseInt(st.nextToken());
	    
	    Queue<int[]> q = new LinkedList<>();
	    boolean[] vis = new boolean[F+1];
	    
	    q.offer(new int[] {S, 0});
	    vis[S] = true;
	    while(!q.isEmpty()) {
	        int[] curr = q.poll();
	        int p = curr[0];
	        int cnt = curr[1];
	        if (p == G) {
	            System.out.println(cnt);
	            return;
	        }
	        
	        if (p+U <= F && !vis[p+U] ) {
	            q.offer(new int[] {p+U, cnt+1});
	            vis[p+U] = true;
	        }
	        
	        if (p-D > 0 && !vis[p-D]) {
	            q.offer(new int[] {p-D, cnt+1});
	            vis[p-D] = true;
	        }
	    }
	    
	    System.out.println("use the stairs");
	}
}

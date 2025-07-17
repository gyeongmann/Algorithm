import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int T = Integer.parseInt(br.readLine());
	    
	    StringBuilder sb = new StringBuilder();
	    for (int t = 0; t < T; t++) {
	        int N = Integer.parseInt(br.readLine());
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        PriorityQueue<Long> pq = new PriorityQueue<>();
	        for (int i = 0; i < N; i++) {
	            pq.offer(Long.parseLong(st.nextToken()));
	        }
	        
	        long a = pq.poll();
	        long b = pq.poll();
	        long sum = a + b;
	        pq.offer(sum);
	        while(!pq.isEmpty()) {
	            a = pq.poll();
	            b = pq.poll();
	            long tmp = a + b;
	            sum += tmp;
	            if (pq.isEmpty()) {
	                break;
	            }
	            pq.offer(tmp);
	        }
	        
	        sb.append(sum).append('\n');
	    }
	    System.out.println(sb.toString());
	}
}
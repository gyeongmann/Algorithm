import java.util.*;
import java.io.*;

public class Main {
    static class Step implements Comparable<Step> {
        int i, count;
        
        public Step(int i, int count) {
            this.i = i;
            this.count = count;
        }
        
        @Override
        public int compareTo(Step o) {
            if (this.count == o.count) {
                return Integer.compare(o.i, this.i);
            }
            return Integer.compare(this.count, o.count);
        }
    }
    
    static int[] di = {1, 2, 3, 4, 5, 6};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] snakeOrLadder = new int[100];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    snakeOrLadder[x] = y;
		}
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int u = Integer.parseInt(st.nextToken());
		    int v = Integer.parseInt(st.nextToken());
		    snakeOrLadder[u] = v;
		}
		
		boolean[] visited = new boolean[101];
		PriorityQueue<Step> pq = new PriorityQueue<>();
		pq.offer(new Step(1, 0));
		
		while(!pq.isEmpty()) {
		    Step curr = pq.poll();
		    
		    for (int i = 0; i < 6; i++) {
		        int d = di[i];
		        int next = curr.i + d;
		        if (!visited[next]) {
		            if (next >= 100) {
		                System.out.println(curr.count+1);
		                return;
		            }
		            visited[next] = true;
		            if (snakeOrLadder[next] != 0) {
		                next = snakeOrLadder[next];
		                visited[next] = true;
		            }
		            pq.offer(new Step(next, curr.count+1));
		        }
		    }
		}
	}
}

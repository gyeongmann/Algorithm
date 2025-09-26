import java.util.*;
import java.io.*;

public class Main {
    static class Node {
        int r, c, cnt, moved;
        
        public Node(int r, int c, int cnt, int moved) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.moved = moved;
        }
        
        public String toString() {
            return r + ", " + c + ", " + cnt + ", " + moved;
        }
    }
    
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[] hr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    int K = Integer.parseInt(br.readLine());
	    st = new StringTokenizer(br.readLine());
	    int W = Integer.parseInt(st.nextToken());
	    int H = Integer.parseInt(st.nextToken());
	    
	    int[][] map = new int[H][W];
	    for (int i = 0; i < H; i++) {
	        st = new StringTokenizer(br.readLine());
	        for (int j = 0; j < W; j++) {
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    Node s = new Node(0, 0, 0, 0);
	    Queue<Node> q = new LinkedList<>();
	    boolean[][][] visited = new boolean[H][W][K+1];
	    q.offer(s);
	    visited[0][0][0] = true;
	    
	    while(!q.isEmpty()) {
	        Node curr = q.poll();
	        
	        int r = curr.r;
	        int c = curr.c;
	        int cnt = curr.cnt;
	        int moved = curr.moved;
	        
	        if (r == H-1 && c == W-1) {
	            System.out.println(moved);
	            return;
	        }
	        
	        for (int i = 0; i < 4; i++) {
	            int nr = r + dr[i];
	            int nc = c + dc[i];
	            if (nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
	            if (visited[nr][nc][cnt] || map[nr][nc] == 1) continue;
	            visited[nr][nc][cnt] = true;
	            q.offer(new Node(nr, nc, cnt, moved+1));
	        }
	        
	        if (cnt < K) {
    	        for (int i = 0; i < 8; i++) {
    	            int nr = r + hr[i];
    	            int nc = c + hc[i];
    	            if (nr < 0 || nc < 0 || nr >= H || nc >= W) continue;
    	            if (visited[nr][nc][cnt+1] || map[nr][nc] == 1) continue;
    	            visited[nr][nc][cnt+1] = true;
    	            q.offer(new Node(nr, nc, cnt+1, moved+1));
    	        }
	        }
	    }
	    
	    System.out.println(-1);
	}
}
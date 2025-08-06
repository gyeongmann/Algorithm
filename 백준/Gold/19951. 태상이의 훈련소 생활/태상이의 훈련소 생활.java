import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(br.readLine());
	    int[] before = new int[N];
	    for (int i = 0; i < N; i++) {
	        before[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] diff = new int[N+1];
	    for (int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
	        int b = Integer.parseInt(st.nextToken());
	        int H = Integer.parseInt(st.nextToken());
	        
	        diff[a-1] += H;
	        diff[b] -= H;
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < N; i++) {
	        diff[i+1] += diff[i];
	        before[i] += diff[i];
	        sb.append(before[i] + " ");
	    }
	    
	    System.out.print(sb.toString());
	}
}

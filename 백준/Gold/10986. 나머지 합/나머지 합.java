import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    
	    int[] A = new int[N];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
	        A[i] = Integer.parseInt(st.nextToken()) % M;
	    }
	    
	    int[] cnt = new int[M];
	    cnt[0]++;
	    cnt[A[0]]++;
	    for (int i = 1; i < N; i++) {
	        A[i] += A[i-1];
	        A[i] %= M;
	        cnt[A[i]]++;
	    }
	    
	    long answer = 0;
	    for (int i = 0; i < M; i++) {
	        answer += comb(cnt[i]);
	    }
	    System.out.println(answer);
	}
	
	private static long comb(int n) {
	    return ((long) n) * ((long) n-1) / 2;
	}
}

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    st = new StringTokenizer(br.readLine());
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    int[] A = new int[2*N];
	    boolean[] robot = new boolean[N];
	    st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < 2*N; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int cnt = 0;
	    int ans = 0;
	    while (cnt < K) {
	        ans++;
	        
	        // 벨트 이동
	        int tmp = A[2*N-1];
	        for (int i = 2*N-1; i > 0; i--) {
	            A[i] = A[i-1];
	        }
	        A[0] = tmp;
	        
	        // 벨트와 같이 이동
	        for (int i = N - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N-1] = false;
	        
	        // 로봇 이동(내구도 감소)
	        for (int i = N-2; i >= 0; i--) {
                if (robot[i] && A[i+1] > 0 && !robot[i+1]) {
                    robot[i] = false;
                    A[i+1]--;
                    if (A[i+1] == 0) cnt++;
                    if (i < N-2) robot[i+1] = true;
                }
	        }
	        
	        // 로봇 올리기
	        if (A[0] > 0 && !robot[0]) {
	            robot[0] = true;
	            A[0]--;
	            if (A[0] == 0) cnt++;
	        }
	    }
	    
	    System.out.println(ans);
	}
}
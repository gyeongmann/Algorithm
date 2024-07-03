import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static final int MAX_VALUE = 1_000_000_000;
	
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        int N = Integer.parseInt(st.nextToken()); // a의 개수
        int M = Integer.parseInt(st.nextToken()); // z의 개수
        int K = Integer.parseInt(st.nextToken()); // K번째

        int[][] dp = new int[N + 1][M + 1]; // 행-a, 열-z
        
        // dp 배열 채우기 -> 역추적
        int r = 0, c = 0;
        for (r = 0; r <= N; r++) {
            for (c = 0; c <= M; c++) {
                if (r == 0 || c == 0) {
                    dp[r][c] = 1;
                    continue;
                }
                
                dp[r][c] = dp[r-1][c] + dp[r][c-1];
                if (dp[r][c] > MAX_VALUE) {
                	dp[r][c] = 1_000_000_001;
                }
            }
        }
        
        r--; c--;
        if (K > dp[r][c]) {
        	System.out.println(-1);
        	return;
        }
        
        StringBuilder sb = new StringBuilder();
        while (r != 0 && c != 0) {
        	int next = dp[r-1][c];
        	if (next >= K) {
        		sb.append("a");
        		r--;
        	}
        	else {
        		sb.append("z");
        		c--;
        		K -= next;
        	}
        }
        
        while (r != 0) {
        	sb.append("a");
        	r--;
        }
        while (c != 0) {
        	sb.append("z");
        	c--;
        }
        System.out.println(sb.toString());
    }

}
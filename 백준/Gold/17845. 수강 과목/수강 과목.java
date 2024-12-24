import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[K+1][N+1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            dp[i] = Arrays.copyOf(dp[i-1], N+1);
            for (int j = T; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j-T] + I);
            }
            // System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[K][N]);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] dp = new long[N+1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            for (int j = N; j >= T; j--) {
                dp[j] = Math.max(dp[j], dp[j-T] + I);
            }
        }

        System.out.println(dp[N]);
    }
}
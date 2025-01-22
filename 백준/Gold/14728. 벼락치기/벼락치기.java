import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            arr[i][0] = K;
            arr[i][1] = S;
        }

        int[][] dp = new int[N + 1][T + 1];
        for (int i = 1; i <= N; i++) {
            int currK = arr[i][0];
            int currS = arr[i][1];

            if (currK > T) {
                for (int t = 0; t <= T; t++) {
                    dp[i][t] = dp[i - 1][t];
                }
                continue;
            }
            for (int t = 0; t < currK; t++) {
                dp[i][t] = dp[i - 1][t];
            }
            for (int t = currK; t <= T; t++) {
                dp[i][t] = Math.max(dp[i - 1][t], dp[i - 1][t - currK] + currS);
            }
        }

        System.out.println(dp[N][T]);
    }
}
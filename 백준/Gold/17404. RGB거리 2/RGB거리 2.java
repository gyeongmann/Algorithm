import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        } // input

        int answer = Integer.MAX_VALUE;
        int[][] dp = new int[N][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[0], 10_000_000);
            dp[0][i] = arr[0][i];
            for (int idx = 1; idx < N; idx++) {
                dp[idx][0] = arr[idx][0] + Math.min(dp[idx-1][1], dp[idx-1][2]);
                dp[idx][1] = arr[idx][1] + Math.min(dp[idx-1][0], dp[idx-1][2]);
                dp[idx][2] = arr[idx][2] + Math.min(dp[idx-1][0], dp[idx-1][1]);
            }

            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    answer = Math.min(answer, dp[N-1][j]);
                }
            }
        }

        System.out.println(answer);
    }
}
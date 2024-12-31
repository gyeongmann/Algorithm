import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 총 객차 수
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int K = Integer.parseInt(br.readLine()); //소형 기관차의 최대 객차 수

        int[] sum = new int[N-K+1];
        int slide = 0;
        for (int i = 0; i < K; i++) {
            slide += arr[i];
        }

        sum[0] = slide;
        for (int i = 0; i < N-K; i++) {
            slide -= arr[i];
            slide += arr[i+K];
            sum[i+1] = slide;
        }

        // System.out.println(Arrays.toString(sum));

        int[][] dp = new int[N-K+1][3];
        dp[0][0] = sum[0];
        for(int i = 1; i < N-K+1; i++) {
            dp[i][0] = Math.max(dp[i-1][0], sum[i]);

            if (i-K >= 0) {
                dp[i][1] = Math.max(dp[i-K][0] + sum[i], dp[i-1][1]);
                dp[i][2] = Math.max(dp[i-K][1] + sum[i], dp[i-1][2]);
            }
        }

        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }

        System.out.println(dp[N-K][2]);
    }
}
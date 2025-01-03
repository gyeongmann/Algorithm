import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        if (N == 1) {
            if (s.equals("B") && B >= 1) {
                System.out.println(1);
                return;
            } else if (s.equals("W") && B == 0) {
                System.out.println(1);
                return;
            }
            System.out.println(0);
            return;
        }

        char[] arr = s.toCharArray();

        int answer = 0;
        for (int i = 0; i < N; i++) { // 시작점
            int[][] dp = new int[2][N];
            if (arr[i] == 'B') {
                dp[0][i] = 1;
            } else {
                dp[1][i] = 1;
            }
            for (int j = i + 1; j < N; j++) { // 현재 위치
                if (arr[j] == 'B') {
                    dp[0][j] = dp[0][j - 1] + 1;
                    dp[1][j] = dp[1][j - 1];
                    if (dp[0][j] > B)
                        break;
                } else {
                    dp[0][j] = dp[0][j - 1];
                    dp[1][j] = dp[1][j - 1] + 1;
                }

                if (dp[0][j] <= B && dp[1][j] >= W) {
                    answer = Math.max(answer, j - i + 1);
                }
            }
        }

        System.out.println(answer);
    }

}
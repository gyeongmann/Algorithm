import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int N, M, K, L;
    static char[][] board;
    static String s;
    static int[][][] dp;
    public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st;
      
      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      
      board = new char[N][M];
      for (int i = 0; i < N; i++) {
          String line = br.readLine();
          for (int j = 0; j < M; j++) {
              char ch = line.charAt(j);
              board[i][j] = ch;
          }
      }
      
      s = br.readLine();
      L = s.length();
      dp = new int[N][M][L];
      for (int r = 0; r < N; r++) {
          for (int c = 0; c < M; c++) {
              Arrays.fill(dp[r][c], -1);
          }
      }
      
      int cnt = 0;
      for (int i = 0; i < N; i++) {
          for (int j = 0; j < M; j++) {
              if (board[i][j] == s.charAt(0)) {
                  cnt += dfs(i, j, 1);
              }
          }
      }
      
      System.out.println(cnt);
    }
    
    static int dfs(int r, int c, int depth) {
        if (depth == L) {
            return 1;
        }
        if (dp[r][c][depth] != -1) return dp[r][c][depth];
        
        dp[r][c][depth] = 0;
        char target = s.charAt(depth);
        for (int k = 1; k <= K; k++) {
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir]*k;
                int nc = c + dc[dir]*k;
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                if (board[nr][nc] == target) {
                    dp[r][c][depth] += dfs(nr, nc, depth+1);
                }
            }
        }
        
        return dp[r][c][depth];
    }
}
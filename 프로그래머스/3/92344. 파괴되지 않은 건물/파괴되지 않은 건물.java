import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int l = board.length;
        int m = board[0].length;
        int[][] nboard = new int[l + 1][m + 1];
        
        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[5];
            
            if (type == 1) {
                nboard[r1][c1] -= degree;
                nboard[r1][c2 + 1] += degree;
                nboard[r2 + 1][c1] += degree;
                nboard[r2 + 1][c2 + 1] -= degree;
            } else if (type == 2) {
                nboard[r1][c1] += degree;
                nboard[r1][c2 + 1] -= degree;
                nboard[r2 + 1][c1] -= degree;
                nboard[r2 + 1][c2 + 1] += degree;
            }
        }
        
        for (int i = 0; i <= l; i++) { // 왼쪽에서 오른쪽으로 누적
            for (int j = 0; j < m; j++) {
                nboard[i][j+1] += nboard[i][j];
            }
        }
        
        for (int i = 0; i < l; i++) { // 위에서 아래로 누적
            for (int j = 0; j <= m; j++) {
                nboard[i+1][j] += nboard[i][j];
            }
        }
        
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += nboard[i][j];
                if (board[i][j] > 0) answer++;
            }
        }
              
        return answer;
    }
}
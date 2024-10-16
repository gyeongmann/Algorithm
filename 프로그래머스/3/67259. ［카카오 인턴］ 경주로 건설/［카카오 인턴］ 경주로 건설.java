import java.util.*;

class Solution {
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    class Node {
        int r, c, dir;
        
        public Node(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }
    }
    
    int N;
    public int solution(int[][] board) {
        int answer = 987654321;
        N = board.length;
        int[][][] nboard = new int[N][N][4];
        boolean[][] vis = new boolean[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) vis[i][j] = true;
            }
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));
        q.add(new Node(0, 0, 1));
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            int r = curr.r;
            int c = curr.c;
            int dir = curr.dir;
            
            // 직진
            int nr = r + dr[dir];
            int nc = c + dc[dir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][dir] == 0 || nboard[r][c][dir] + 100 <= nboard[nr][nc][dir]) {
                    q.add(new Node(nr, nc, dir));
                    nboard[nr][nc][dir] = nboard[r][c][dir] + 100;
                }
            }
            
            // 좌회전
            int ndir = (dir + 1) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][ndir] == 0 || nboard[r][c][dir] + 600 <= nboard[nr][nc][ndir]) {
                    q.add(new Node(nr, nc, ndir));
                    nboard[nr][nc][ndir] = nboard[r][c][dir] + 600;
                }
            }
            
            // 우회전
            ndir = (dir + 3) % 4;
            nr = r + dr[ndir];
            nc = c + dc[ndir];
            if (isValid(nr, nc) && !vis[nr][nc]) {
                // 방문한적 없거나 현재 비용이 더 효율적이면
                if (nboard[nr][nc][ndir] == 0 || nboard[r][c][dir] + 600 <= nboard[nr][nc][ndir]) {
                    q.add(new Node(nr, nc, ndir));
                    nboard[nr][nc][ndir] = nboard[r][c][dir] + 600;
                }
            }
        }
        
        for (int i = 0; i < 4; i++) {
            if (nboard[N-1][N-1][i] == 0) continue;
            answer = Math.min(answer, nboard[N-1][N-1][i]);
        }

        return answer;
    }
    
    boolean isValid(int nr, int nc) {
        if (nr == 0 && nc == 0) return false;
        if (nr >= 0 && nc >= 0 && nr < N && nc < N) return true;
        return false;
    }
}
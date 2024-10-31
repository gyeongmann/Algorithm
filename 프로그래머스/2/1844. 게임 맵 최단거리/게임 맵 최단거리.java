import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;
        int R = maps.length;
        int C = maps[0].length;
        
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[R][C];
        q.offer(new int[] {0, 0});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (vis[nr][nc] || maps[nr][nc] == 0) continue;
                q.offer(new int[] {nr, nc});
                vis[nr][nc] = true;
                maps[nr][nc] += maps[curr[0]][curr[1]];
            }
        }
        if (vis[R-1][C-1]) answer = maps[R-1][C-1];
        else return -1;
        return answer;
    }
}
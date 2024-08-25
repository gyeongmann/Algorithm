import java.util.*;

class Solution {
    boolean[][] vis;
    int n, m;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        for (int col = 0; col < m; col++) {
            map.put(col, 0);
        }
        
        vis = new boolean[n][m];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (vis[r][c]) continue;
                if (land[r][c] == 0) continue;
                BFS(r, c, land);
            }
        }
        
        for (int col = 0; col < m; col++) {
            answer = Math.max(answer, map.get(col));
        }
        
        return answer;
    }
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    public void BFS(int row, int col, int[][] land) {
        int cnt = 0;
        Queue<Integer[]> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new Integer[] {row, col});
        vis[row][col] = true;
        cnt++;
        set.add(col);
        
        while (!q.isEmpty()) {
            Integer[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (land[nr][nc] == 0) continue;
                if (vis[nr][nc]) continue;
                q.add(new Integer[] {nr, nc});
                vis[nr][nc] = true;
                cnt++;
                set.add(nc);
            }
        }
        
        for (int idx : set) {
            map.put(idx, map.get(idx) + cnt);
        }
    }
}
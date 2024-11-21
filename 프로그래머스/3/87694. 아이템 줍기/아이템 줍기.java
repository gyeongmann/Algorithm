import java.util.*;
class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    map[y][x] = 1;
                }
            }
            
            // for (int y = 20; y >= 0; y--) {
            //     for (int x = 0; x <= 20; x++) {
            //         System.out.print(map[y][x] + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[101][101];
        q.offer(new int[] {characterY*2, characterX*2, 0});
        vis[0][0] = true;
        
        int[] dy = {1, 0, -1, 0};
        int[] dx = {0, 1, 0, -1};
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int y = curr[0];
            int x = curr[1];
            int cost = curr[2];
            if (x == itemX * 2 && y == itemY * 2) return cost/2;
            
            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                
                if (ny <= 0 || nx <= 0 || ny > 100 || nx > 100) continue;
                if (vis[ny][nx]) continue;
                if (map[ny][nx] == 0) continue;
                if (!isInside(nx, ny, rectangle)) {
                    q.offer(new int[] {ny, nx, cost+1});
                    vis[ny][nx] = true;
                }
            }
        }
        return answer;
    }
    
    boolean isInside(int x, int y, int[][] rectangle) {
        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;
            
            if (x1 < x && x < x2 && y1 < y && y < y2) return true;
        }
        return false;
    }
}
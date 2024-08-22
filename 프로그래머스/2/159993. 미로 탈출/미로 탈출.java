import java.util.*;

class Solution {
    
    public int solution(String[] maps) {
        int answer = 0;
        int l1 = maps.length;
        int l2 = maps[0].length();
        char[][] map = new char[l1][l2];
        int[][][] vis = new int[l1][l2][2];
        
        for (int r = 0; r < l1; r++) {
            for (int c = 0; c < l2; c++) {
                for (int z = 0; z < 2; z++) {
                    vis[r][c][z] = 987654321;
                }
            }
        }
        
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];
        
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, -1, 0, 1};
        
        for (int r = 0; r < l1; r++) {
            String s = maps[r];
            for (int c = 0; c < l2; c++) {
                if (s.charAt(c) == 'S') {
                    start[0] = r;
                    start[1] = c;
                } else if (s.charAt(c) == 'E') {
                    end[0] = r;
                    end[1] = c;
                } else if (s.charAt(c) == 'L') {
                    lever[0] = r;
                    lever[1] = c;
                } else if (s.charAt(c) == 'O') {
                    map[r][c] = 'O';
                } else if (s.charAt(c) == 'X') {
                    map[r][c] = 'X';
                }
            }
        }
        
        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[] {start[0], start[1], 0});
        vis[start[0]][start[1]][0] = 0;
        
        while(!q.isEmpty()) {
            Integer[] curr = q.poll();
            
            int r = curr[0];
            int c = curr[1];
            int z = curr[2];
            int time = vis[r][c][z];
            
            // System.out.println(Arrays.toString(curr) + " " + time);
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nz = z;
                
                if (nr < 0 || nc < 0 || nr >= l1 || nc >= l2) continue;
                if (map[nr][nc] == 'X') continue;
                if (vis[nr][nc][nz] != 987654321) continue;
                
                if (nr == end[0] && nc == end[1] && nz == 1) {
                    return time+1;
                }
                if (nr == lever[0] && nc == lever[1]) nz = 1;

                q.add(new Integer[] {nr, nc, nz});
                vis[nr][nc][nz] = Math.min(time + 1, vis[nr][nc][nz]);
            }
        }
        
        answer = vis[end[0]][end[1]][1];
        // System.out.println(answer);
        
        if (answer == 987654321) answer = -1;
        return answer;
    }
}
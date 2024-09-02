import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int idx = 0;
        for (String[] place : places) {
            answer[idx++] = solve(place);
        }
        
        return answer;
    }
    
    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};
    
    boolean[][] vis;
    
    public int solve(String[] place) {
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                if (place[row].charAt(col) == 'P') {
                    Queue<int[]> q = new LinkedList<>();
                    vis = new boolean[5][5];
                    
                    q.add(new int[] {row, col});
                    vis[row][col] = true;
                    
                    for (int depth = 0; depth < 2; depth++) {
                        int size = q.size();
                        for (int i = 0; i < size; i++) {
                            int[] curr = q.poll();
                            int r = curr[0];
                            int c = curr[1];
                            
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dr[d];
                                int nc = c + dc[d];
                                if (nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                                if (vis[nr][nc]) continue;
                                if (place[nr].charAt(nc) == 'X') continue;
                                if (place[nr].charAt(nc) == 'P') return 0;
                                q.add(new int[] {nr, nc});
                                vis[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
        return 1;
    }
}
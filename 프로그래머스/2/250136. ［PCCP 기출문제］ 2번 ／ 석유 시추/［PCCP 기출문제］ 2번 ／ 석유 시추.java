import java.util.*;

class Solution {
    
    int[] dr = new int[] {1, 0, -1, 0};
    int[] dc = new int[] {0, 1, 0, -1};
    public int solution(int[][] land) {
        int answer = 0;
        int m = land.length;
        int n = land[0].length;
        
        int[][] index = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        int idx = 0;
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        ans.add(-1);
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (land[r][c] == 1 && !vis[r][c]) {
                    idx++;
                    q.clear();
                    list.clear();
                    q.add(new int[] {r, c});
                    list.add(new int[] {r, c});
                    vis[r][c] = true;
                    
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();
                        
                        for (int i = 0; i < 4; i++) {
                            int nr = curr[0] + dr[i];
                            int nc = curr[1] + dc[i];
                            
                            if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                            if (land[nr][nc] == 0 || vis[nr][nc]) continue;
                            
                            q.add(new int[] {nr, nc});
                            list.add(new int[] {nr, nc});
                            vis[nr][nc] = true;
                        }
                    }
                    
                    int size = list.size();
                    for (int[] e : list) {
                        index[e[0]][e[1]] = idx;
                    }
                    ans.add(size);
                }
            }
        }
        
        // for (int[] row : index) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println(ans);
        
        for (int c = 0; c < n; c++) {
            boolean[] check = new boolean[idx+1];
            int cnt = 0;
            for (int r = 0; r < m; r++) {
                if (index[r][c] == 0) continue;
                check[index[r][c]] = true;
            }
            for (int i = 1; i <= idx; i++) {
                if (check[i]) cnt += ans.get(i);
            }
            answer = Math.max(answer, cnt);
        }
        return answer;
    }
}
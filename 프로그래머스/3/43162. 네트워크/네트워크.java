import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {        
        boolean[] visited = new boolean[n];
        int[] group = new int[n];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            q.clear();
            q.add(i);
            visited[i] = true;
            group[i] = ++idx;
            
            while (!q.isEmpty()) {
                int curr = q.poll();
                
                for (int j = 0; j < n; j++) {
                    if (computers[curr][j] == 0) continue;
                    if (visited[j]) continue;
                    q.add(j);
                    visited[j] = true;
                    group[j] = idx;
                }
            }
        }
        
        return idx;
    }
}
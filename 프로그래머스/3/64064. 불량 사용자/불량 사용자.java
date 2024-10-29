import java.util.*;

class Solution {
    int cnt = 0;
    boolean[] visited;
    Set<Set<Integer>> tmp = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        
        int r = user_id.length;
        int c = banned_id.length;
        visited = new boolean[r];
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (compare(user_id[i], banned_id[j])) {
                    map[i][j] = 1;
                }
            }
        }
        
        // for (int[] row : map) {
        //     System.out.println(Arrays.toString(row));
        // }
        // System.out.println();
        
        dfs(0, new HashSet<Integer>(), map);
        // for (Set<Integer> row : tmp) {
        //     System.out.println(row);
        // }
        answer = tmp.size();
        return answer;
    }
    
    void dfs(int banIdx, Set<Integer> set, int[][] map) {
        if (banIdx == map[0].length) {
            // if (!tmp.contains(set)) {
            //     System.out.println(set);
            // }
            tmp.add(set);
            return;
        }
        
        for (int i = 0; i < map.length; i++) {
            if (set.contains(i)) continue;
            
            if (map[i][banIdx] == 1) {
                set.add(i);
                dfs(banIdx+1, new HashSet<>(set), map);
                set.remove(i);
            }
        }
    }
    
    boolean compare(String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) return false;
        
        for (int i = 0; i < user_id.length(); i++) {
            char ch1 = user_id.charAt(i);
            char ch2 = banned_id.charAt(i);
            if (ch2 == '*') continue;
            if (ch1 != ch2) return false;
        }
        return true;
    }
}
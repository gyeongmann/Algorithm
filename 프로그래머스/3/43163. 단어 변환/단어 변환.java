import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int targetIdx = check(target, words);
        if (targetIdx == -1) return 0;
        
        int N = words.length;
        List<Integer>[] adj = new List[N+1]; // N: begin
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }
        
        // adj 연결
        for (int i = 0; i < N; i++) {
            String w = words[i];
            if (diffCnt(begin, w) == 1) {
                adj[N].add(i); // N -> i
            }
        }
        
        for (int i = 0; i < N; i++) {
            String curr = words[i];
            if (diffCnt(curr, begin) == 1) {
                adj[i].add(N);
            }
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (diffCnt(curr, words[j]) == 1) {
                    adj[i].add(j);
                }
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[N+1];
        q.offer(N);
        vis[N] = true;
        int depth = 0;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curr = q.poll();
                
                if (curr == targetIdx) return depth;
                for (int next : adj[curr]) {
                    if (vis[next]) continue;
                    q.offer(next);
                    vis[next] = true;
                }
            }
            depth++;
        }
        
        return answer;
    }
    
    int check(String target, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (target.equals(words[i])) return i;
        }
        return -1;
    }
    
    int diffCnt(String curr, String target) {
        int cnt = 0;
        for (int i = 0; i < curr.length(); i++) {
            if (curr.charAt(i) != target.charAt(i)) cnt++;
        }
        return cnt;
    }
}
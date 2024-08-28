import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        int n = jobs.length;
        
        // 시작 시간 기준으로 오름차순 정렬
        Arrays.sort(jobs, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int prevEnd = 0;
        int idx = 0;
        int cnt = 0;
        while (cnt < n) {
            while (idx < n && jobs[idx][0] <= prevEnd) {
                pq.add(jobs[idx++]);
            }
            
            if (pq.isEmpty()) {
                prevEnd = jobs[idx][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + prevEnd - tmp[0];
                prevEnd += tmp[1];
                cnt++;
            }
        }
        
        return (int) Math.floor(answer / n);
    }
}
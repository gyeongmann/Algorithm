import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s);
        }
        
        boolean find = false;
        while (pq.size() > 1) {
            int min1 = pq.poll();
            if (min1 >= K) {
                find = true;
                break;
            }
            int min2 = pq.poll();
            int next = min1 + min2 * 2;
            pq.offer(next);
            answer++;
        }
        
        if (!find) {
            int last = pq.poll();
            if (last < K) return -1;
        }
        return answer;
    }
}
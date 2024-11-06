import java.util.*;

class Solution {
    class Node {
        int idx, num;
        
        public Node(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }
    }
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Node> q1 = new LinkedList<>();
        long sum1 = 0;
        for (int i = 0; i < queue1.length; i++) {
            q1.offer(new Node(1, queue1[i]));
            sum1 += queue1[i];
        }
        
        Queue<Node> q2 = new LinkedList<>();
        long sum2 = 0;
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(new Node(2, queue2[i]));
            sum2 += queue2[i];
        }
        
        int cnt = 0;
        while (sum1 != sum2) {
            if (cnt > queue1.length + queue2.length + 1) return -1;
            answer++;
            cnt++;
            if (sum1 < sum2) {
                Node curr = q2.poll();
                q1.offer(curr);
                sum1 += curr.num;
                sum2 -= curr.num;
            } else if (sum1 > sum2) {
                Node curr = q1.poll();
                q2.offer(curr);
                sum1 -= curr.num;
                sum2 += curr.num;
            }
        }
        
        return answer;
    }
}
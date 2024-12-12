import java.util.*;

class Solution {
    int[] bridge;
    int total, curr;
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int w : truck_weights) {
            total += w;
            q.offer(w);
        }
        
        bridge = new int[bridge_length];
        
        curr = 0;
        while (total > 0) {
            move();
            if (!q.isEmpty() && curr + q.peek() <= weight) {
                curr += q.peek();
                push(q.poll());
            }
            answer++;
        }
        
        return answer;
    }
    
    void move() {
        total -= bridge[0];
        curr -= bridge[0];
        for (int i = 1; i < bridge.length; i++) {
            bridge[i-1] = bridge[i];
        }
        bridge[bridge.length-1] = 0;
    }
    
    void push(int x) {
        bridge[bridge.length-1] = x;
    }
}
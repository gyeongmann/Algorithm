import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int n = people.length;
        PriorityQueue<Integer> light = new PriorityQueue<>();
        PriorityQueue<Integer> heavy = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2, o1));
        int mean = limit / 2;
        for (int i = 0; i < n; i++) {
            if (people[i] > mean) heavy.add(people[i]);
            else light.add(people[i]);
        }
        
        while (!heavy.isEmpty()) {
            int curr = heavy.poll();
            if (!light.isEmpty() && light.peek() + curr <= limit) {
                light.poll();
            }
            answer++;
        }
        
        
        int size = light.size();
        answer += size / 2;
        if (size % 2 != 0) answer++;
        
        return answer;
    }
}
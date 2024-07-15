import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        StringTokenizer st;
        int[] time = new int[1450]; // 23(시)*60+59(분)+10(청소) = 1449
        for (String[] t : book_time) {
            String start = t[0];
            String end = t[1];
            st = new StringTokenizer(start, ":");
            int start_time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
            st = new StringTokenizer(end, ":");
            int end_time = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken()) + 10;
            
            for (int i = start_time; i < end_time; i++) {
                time[i]++;
            }
        }
        int answer = 0;
        for (int i = 0; i < 1450; i++) {
            answer = Math.max(answer, time[i]);
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        Map<Character, Integer> priority = new HashMap<>();
        
        for (int i = 0; i < skill.length(); i++) {
            priority.put(skill.charAt(i), i);
        }
        // System.out.println(priority);
        
        Stack<Integer> st;
        for (String s : skill_trees) {
            st = new Stack<>();
            st.push(-1);
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                char curr = s.charAt(i);
                if (!priority.containsKey(curr)) continue;
                int prior = priority.get(curr);
                if (prior != st.peek() + 1) {
                    flag = false;
                    break;
                }
                st.push(prior);
            }
            if (flag) answer++;
        }
        return answer;
    }
}
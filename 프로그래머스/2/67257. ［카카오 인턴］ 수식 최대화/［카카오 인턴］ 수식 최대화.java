import java.util.*;

class Solution {
    
    char[][] op = {{'*', '+', '-'},
                   {'*', '-', '+'},
                   {'+', '*', '-'},
                   {'+', '-', '*'},
                   {'-', '*', '+'},
                   {'-', '+', '*'}};
    
    public long solution(String expression) {
        long answer = 0;
        int l = expression.length();
        
        int idx = 0;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            char ch = expression.charAt(i);
            if (ch == '*' || ch == '+' || ch == '-') {
                list.add(expression.substring(idx, i));
                list.add(Character.toString(ch));
                idx = i + 1;
            }
        }
        list.add(expression.substring(idx, l));
        // System.out.println(list);
        
        Deque<String> q = new LinkedList<>();
        for (int i = 0; i < 6; i++) {
            for (String s : list) {
                q.add(s);
            }
            
            for (int j = 0; j < 3; j++) {
                char operator = op[i][j];
                
                // System.out.println(operator);
                
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    String curr = q.pollFirst();
                    
                    if (curr.equals(Character.toString(operator))) {
                        long tmp = 0;
                        if(curr.equals("*")) {
                            tmp = Long.parseLong(q.pollLast()) * Long.parseLong(q.pollFirst());
                        } else if (curr.equals("+")) {
                            tmp = Long.parseLong(q.pollLast()) + Long.parseLong(q.pollFirst());
                        } else if (curr.equals("-")) {
                            tmp = Long.parseLong(q.pollLast()) - Long.parseLong(q.pollFirst());
                        }
                        
                        q.offerLast(String.valueOf(tmp));
                        k++;
                        // System.out.println(q);
                    } else {
                        q.offerLast(curr);
                    }
                }
                // System.out.println(q);
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(q.poll())));
        }
        return answer;
    }
    
}
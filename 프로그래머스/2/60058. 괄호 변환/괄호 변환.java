import java.util.*;

class Solution {
    public String solution(String p) {
        // System.out.println(isClear(p));
        String answer = solve(p); 
        return answer;
    }
    
    // 올바른 문자열인지
    boolean isClear(String s) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') st.push(ch);
            else {
                if (st.isEmpty()) return false;
                st.pop();
            }
        }
        return true;
    }
    
    // 분리
    String solve(String p) {
        if (isClear(p)) {
            return p;
        }
        
        int open = 0;
        int close = 0;
        if (p.length() > 0) {
            if (p.charAt(0) == '(') {
                open++;
            } else close++;
        }
        
        int idx = 1;
        while (open != close) {
            if (p.length() == idx) break;
            if (p.charAt(idx++) == '(') {
                open++;
            } else close++;
        }
        
        String u = p.substring(0, idx);
        String v = p.substring(idx, p.length());
        
        if (isClear(u)) {
            v = solve(v);
            return u + v;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append(solve(v));
        sb.append(')');
        sb.append(reverse(u.substring(1, u.length() - 1)));
        return sb.toString();
    }
    
    String reverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                sb.append(')');
                continue;
            }
            sb.append('(');
        }
        return sb.toString();
    }
}
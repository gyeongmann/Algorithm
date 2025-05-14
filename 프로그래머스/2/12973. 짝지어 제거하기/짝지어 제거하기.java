import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        Stack<Character> st = new Stack<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (st.isEmpty())  {
                st.push(ch);
            } else if (st.peek() == ch) {
                st.pop();
            } else {
                st.push(ch);
            }
        }

        if (st.isEmpty()) {
            answer = 1;
        }
        return answer;
    }
    
}
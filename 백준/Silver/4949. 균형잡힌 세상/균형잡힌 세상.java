import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            String s = sc.nextLine();
            int l = s.length();
            if (l == 1 && s.charAt(0) == '.') break;
            Stack<Character> st = new Stack<>();
            boolean fail = false;
            for (int i = 0; i < l; i++) {
                char ch = s.charAt(i);
                if (ch == '(' || ch == '[') {
                    st.push(ch);
                } else if (ch == ')') {
                    if (st.isEmpty()) {
                        fail = true;
                        break;
                    }
                    
                    if (st.peek() == '(') {
                        st.pop();
                    } else {
                        fail = true;
                        break;
                    }
                } else if (ch == ']') {
                    if (st.isEmpty()) {
                        fail = true;
                        break;
                    }
                    
                    if (st.peek() == '[') {
                        st.pop();
                    } else {
                        fail = true;
                        break;
                    }
                }
            }
            
            if (!st.isEmpty()) {
                fail = true;
            }
            
            if (fail) {
                sb.append("no").append('\n');
            } else {
                sb.append("yes").append('\n');
            }
        }
        
        System.out.println(sb.toString());
    }
}
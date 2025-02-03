import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<String>();
        for (String s : phone_book) {
            set.add(s);
        }
        
        for (String s : phone_book) {
            int l = s.length();
            for (int i = 0; i < l; i++) {
                String prefix = s.substring(0, i);
                if (set.contains(prefix)) return false;
            }
        }
        return true;
    }
}
import java.util.*;

class Solution {
    int l;
    String[] answer;
    public String[] solution(String[][] tickets) {
        l = tickets.length;
        answer = new String[l+1];
        
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) return a[1].compareTo(b[1]);
            return a[0].compareTo(b[0]);
        });
        
        List<String> list = new ArrayList<>();
        list.add("ICN");
        backtracking("ICN", tickets, 1, list, new boolean[l+1]);
        
        return answer;
    }
    
    boolean backtracking(String from, String[][] tickets, int cnt, List<String> path, boolean[] visited) {
        if (cnt == l+1) {
            System.out.println(path);
            for (int i = 0; i <= l; i++) {
                answer[i] = path.get(i);
            }
            return true;
        }
        
        for (int i = 0; i < l; i++) {
            if (visited[i]) continue;
            String[] ticket = tickets[i];
            if (!from.equals(ticket[0])) continue;
            
            visited[i] = true;
            String to = ticket[1];
            path.add(to);
            if (backtracking(to, tickets, cnt+1, path, visited)) return true;
            path.remove(path.size() - 1);
            visited[i] = false;
        }
        
        return false;
    }
}
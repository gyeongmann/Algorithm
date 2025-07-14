import java.util.*;

public class Main {
    static class State {
        int screen, clipboard, time;

        State(int screen, int clipboard, int time) {
            this.screen = screen;
            this.clipboard = clipboard;
            this.time = time;
        }
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int S = Integer.parseInt(sc.nextLine());
	    
	    Queue<State> q = new LinkedList<>();
	    q.offer(new State(1, 0, 0));
	    boolean[][] visited = new boolean[2001][2001];
	    visited[1][0] = true;
	    while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.screen == S) {
                System.out.println(cur.time);
                return;
            }

            // 1. 복사
            if (!visited[cur.screen][cur.screen]) {
                visited[cur.screen][cur.screen] = true;
                q.offer(new State(cur.screen, cur.screen, cur.time + 1));
            }

            // 2. 붙여넣기
            if (cur.clipboard > 0 && cur.screen + cur.clipboard <= 2000) {
                if (!visited[cur.screen + cur.clipboard][cur.clipboard]) {
                    visited[cur.screen + cur.clipboard][cur.clipboard] = true;
                    q.offer(new State(cur.screen + cur.clipboard, cur.clipboard, cur.time + 1));
                }
            }

            // 3. 삭제
            if (cur.screen > 1 && !visited[cur.screen - 1][cur.clipboard]) {
                visited[cur.screen - 1][cur.clipboard] = true;
                q.offer(new State(cur.screen - 1, cur.clipboard, cur.time + 1));
            }
        }
	}
	
}

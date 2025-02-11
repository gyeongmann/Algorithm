import java.util.*;
import java.io.*;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int compareTo(Point o) {
            if (this.x == o.x) {
                return Integer.compare(this.y, o.y);
            }
            return Integer.compare(this.x, o.x);
        }

        public String toString() {
            return x + ", " + y;
        }
    }

    static TreeSet<Point> map = new TreeSet<>();
    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) * 2;
            int y1 = Integer.parseInt(st.nextToken()) * 2;
            int x2 = Integer.parseInt(st.nextToken()) * 2;
            int y2 = Integer.parseInt(st.nextToken()) * 2;
            for (int x = x1; x <= x2; x++) {
                map.add(new Point(x, y1));
                map.add(new Point(x, y2));
            }
            for (int y = y1; y <= y2; y++) {
                map.add(new Point(x1, y));
                map.add(new Point(x2, y));
            }
        }

        // for (Point key : map) {
        // System.out.println(key);
        // }

        int answer = 0;
        Point start = new Point(0, 0);
        if (map.contains(start)) {
            dfs(start);
        }

        while (map.size() > 0) {
            answer++;
            // System.out.println(answer);
            start = map.first();
            dfs(start);
            // System.out.println();
        }

        System.out.println(answer);
    }

    private static void dfs(Point curr) {
        // System.out.println("curr: " + curr);
        map.remove(curr);
        for (int i = 0; i < 4; i++) {
            int nx = curr.x + dx[i];
            int ny = curr.y + dy[i];
            Point next = new Point(nx, ny);
            if (map.contains(next)) {
                dfs(next);
            }
        }
    }
}
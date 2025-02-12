import java.util.*;
import java.io.*;

public class Main {
    static class Town implements Comparable<Town> {
        int x, a;

        public Town(int x, int a) {
            this.x = x;
            this.a = a;
        }

        public int compareTo(Town o) {
            return Integer.compare(this.x, o.x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        List<Town> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            sum += a;
            list.add(new Town(x, a));
        }
        Collections.sort(list);
        long half = (sum + 1) / 2;

        long cnt = 0;
        int idx = 0;
        for (idx = 0; idx < list.size(); idx++) {
            cnt += list.get(idx).a;
            if (cnt >= half)
                break;
        }
        System.out.println(list.get(idx).x);
    }
}
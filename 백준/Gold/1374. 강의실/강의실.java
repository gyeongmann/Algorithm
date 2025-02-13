import java.util.*;
import java.io.*;

public class Main {

    static class Lecture implements Comparable<Lecture> {
        int idx, s, e;

        public Lecture(int idx, int s, int e) {
            this.idx = idx;
            this.s = s;
            this.e = e;
        }

        public int compareTo(Lecture o) {
            if (this.s == o.s) {
                if (this.e == o.e) {
                    return Integer.compare(this.idx, o.idx);
                }
                return Integer.compare(this.e, o.e);
            }
            return Integer.compare(this.s, o.s);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Lecture(idx, s, e));
        }

        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Lecture l : list) {
            if (!pq.isEmpty() && pq.peek() <= l.s) {
                pq.poll();
            }
            pq.offer(l.e);
        }

        System.out.println(pq.size());
    }
}
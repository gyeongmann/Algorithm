import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(in.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0 ; i < N; i++) {
            pq.add(Integer.parseInt(in.readLine()));
        }
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append('\n');
        }
        System.out.println(sb);
    }
}
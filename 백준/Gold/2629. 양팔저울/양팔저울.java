import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int total = 0;
        int N = Integer.parseInt(br.readLine()); // 추의 개수
        st = new StringTokenizer(br.readLine());
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
            total += weight[i];
        }

        int K = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] quest = new int[K];
        for (int i = 0; i < K; i++) {
            quest[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> vis = new HashSet<>();
        vis.add(0);
        for (int i = 0; i < N; i++) {
            int curr = weight[i];
            Integer[] arr = vis.toArray(new Integer[0]);
            for (int w : arr) {
                if (curr >= w) {
                    vis.add(curr-w);
                } else {
                    vis.add(w-curr);
                }
                vis.add(curr+w);
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int q : quest) {
            if (vis.contains(q)) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }
        System.out.println(sb);
    }
}
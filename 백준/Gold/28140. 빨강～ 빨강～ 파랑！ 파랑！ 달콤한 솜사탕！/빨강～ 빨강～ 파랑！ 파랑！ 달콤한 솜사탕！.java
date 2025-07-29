import java.util.*;
import java.io.*;

public class Main {
    static List<Integer> rIdx = new ArrayList<>();
    static List<Integer> bIdx = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        String S = br.readLine();

        for (int i = 0; i < N; i++) {
            if (S.charAt(i) == 'R') {
                rIdx.add(i);
            } else if (S.charAt(i) == 'B') {
                bIdx.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            int a = lowerBound(rIdx, l);
            int b = a + 1;

            if (b >= rIdx.size() || rIdx.get(b) > r) {
                sb.append("-1\n");
                continue;
            }

            int c = lowerBound(bIdx, rIdx.get(b) + 1); // b < c
            int d = c + 1;

            if (d >= bIdx.size() || bIdx.get(d) > r) {
                sb.append("-1\n");
                continue;
            }

            sb.append(rIdx.get(a)).append(" ").append(rIdx.get(b)).append(" ")
              .append(bIdx.get(c)).append(" ").append(bIdx.get(d)).append("\n");
        }

        System.out.print(sb);
    }

    static int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size(); // exclusive

        while (left < right) {
            int mid = (left + right) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}

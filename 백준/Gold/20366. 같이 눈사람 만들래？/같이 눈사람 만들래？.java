import java.io.*;
import java.util.*;;

public class Main {
    static class Pair implements Comparable<Pair> {
        long sum;
        int idx1, idx2;

        Pair(int x, int y, int idx1, int idx2) {
            this.sum = x + y;
            this.idx1 = idx1;
            this.idx2 = idx2;
        }

        public int compareTo(Pair o) {
            return Long.compare(this.sum, o.sum);
        }

        public boolean isOverlap(Pair o) {
            if (this.idx1 == o.idx1 || this.idx2 == o.idx1 || this.idx1 == o.idx2 || this.idx2 == o.idx2) {
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 모든 Pair 계산 후 리스트에 저장
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                pairs.add(new Pair(arr[i], arr[j], i, j));
            }
        }

        // Pair 리스트 정렬
        Collections.sort(pairs);

        long ans = Long.MAX_VALUE;
        for (int i = 0; i < pairs.size() - 1; i++) {
            Pair curr = pairs.get(i);
            Pair next = pairs.get(i + 1);
            if (!curr.isOverlap(next)) {
                ans = Math.min(ans, Math.abs(next.sum - curr.sum));
            }
        }

        System.out.println(ans);
    }
}
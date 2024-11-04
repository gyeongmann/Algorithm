import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 학급 수
        int M = Integer.parseInt(st.nextToken()); // 학생 수

        // 학급, 능력치
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        for (int classNumber = 0; classNumber < N; classNumber++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                pq.offer(new int[] {classNumber, Integer.parseInt(st.nextToken())});
            }
        }

//        while (!pq.isEmpty()) {
//            System.out.println(Arrays.toString(pq.poll()));
//        }

        int answer = Integer.MAX_VALUE;
        int[] arr = new int[N];
        Arrays.fill(arr, -1);
        boolean keepLoop = true;
        while (keepLoop) {
            keepLoop = false;
            int[] curr = pq.poll();
            arr[curr[0]] = curr[1];

            for (int i = 0; i < N; i++) {
                if (arr[i] == -1) keepLoop = true;
            }
//            System.out.println(Arrays.toString(arr));
        }

//        System.out.println("-------------------------");
        int min = Integer.MAX_VALUE;
        int max = -1;
        for (int i = 0; i < N; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        answer = Math.min(answer, max - min);

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            arr[curr[0]] = curr[1];

//            System.out.println(Arrays.toString(arr));
            min = Integer.MAX_VALUE;
            max = -1;
            for (int i = 0; i < N; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);
            }
            answer = Math.min(answer, max - min);
        }
        System.out.println(answer);
    }
}
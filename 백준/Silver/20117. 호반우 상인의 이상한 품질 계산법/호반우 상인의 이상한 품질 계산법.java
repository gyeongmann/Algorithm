import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < N; i++) {
            deque.offer(arr[i]);
        }

        int answer = 0;
        while(deque.size() >= 2) {
            int first = deque.pollFirst();
            int last = deque.pollLast();

            answer += last * 2;
        }

        if (!deque.isEmpty()) {
            answer += deque.pollFirst();
        }

        System.out.println(answer);
    }
}
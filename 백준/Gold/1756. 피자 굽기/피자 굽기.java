import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
     * 1. oven은 위보다 아래가 넓은 것이 의미가 없다. 위보다 아래가 넓으면 위와 동일한 값으로 변경
     * 2. 주어진 피자의 너비를 만족하는 값을 oven에서 이분 탐색한다.
     * 3-1. 주어진 오븐에 들어가지 않으면 0 출력
     * 3-2. 들어가면 해당 위치 위부터로 탐색 범위 축소
     */

    static int D, N;
    static int[] oven, pizzas;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());

        D = Integer.parseInt(st.nextToken()); // 오븐의 깊이
        N = Integer.parseInt(st.nextToken()); // 피자의 개수
        oven = new int[D];
        pizzas = new int[N];

        st = new StringTokenizer(in.readLine()); // 2번째 줄
        int min = Integer.MAX_VALUE;
        for (int i = D - 1; i >= 0; i--) {
            int curr = Integer.parseInt(st.nextToken());
            if (curr < min)
                min = curr;
            oven[i] = min;
        }

        st = new StringTokenizer(in.readLine()); // 3번째 줄
        for (int i = 0; i < N; i++) {
            pizzas[i] = Integer.parseInt(st.nextToken());
        }

        // 이분 탐색
        int left = 0;
        int right = D - 1;
        int mid = 0;
        int ans = 0;
        boolean avail = true; // 모두 다 들어갈 수 있는지
        for (int i = 0; i < N; i++) {
            int pizza = pizzas[i];
            if (left > right || oven[right] < pizza) { // 꽉찼거나 오븐 입구보다 큰 피자가 나오면
                avail = false;
                System.out.println(0);
                break;
            }
            while (avail && left <= right) {
                mid = (left + right) / 2;
                if (oven[mid] >= pizza) {
                    ans = mid;
                    right = mid - 1;
                } else
                    left = mid + 1;
            }

            left = ans + 1;
            right = D - 1;
        }
        
        if(avail) System.out.println(D - ans);
    }
}
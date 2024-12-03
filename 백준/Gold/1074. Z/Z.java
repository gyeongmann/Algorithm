import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int answer = 0;

        while(N-- > 1) {
            int half = (int) Math.pow(2, N);
            int weight = (int) Math.pow(half, 2);

            if (r < half && c < half) { // 좌상
                answer += weight * 0;
            } else if (r < half && c >= half) { // 우상
                answer += weight * 1;
                c -= half;
            } else if (r >= half && c < half) { // 좌하
                answer += weight * 2;
                r -= half;
            } else { // 우하
                answer += weight * 3;
                r -= half;
                c -= half;
            }
        }

        if (r == 0 && c == 0) {
            System.out.println(answer);
        } else if (r == 0 && c == 1) {
            System.out.println(answer + 1);
        } else if (r == 1 && c == 0) {
            System.out.println(answer + 2);
        } else {
            System.out.println(answer + 3);
        }

    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        int tmp = N;
        if (N % 2 == 0) {
            int i = 0;

            for (i = N - 2; i >= 0; i-=2) {
                arr[i] = tmp--;
            }

            for (i = 1; i < N; i+=2) {
                arr[i] = tmp--;
            }
        } else {
            int i = 0;
            for (i = N - 1; i >= 0; i-=2) {
                arr[i] = tmp--;
            }

            for (i = 1; i < N; i+=2) {
                arr[i] = tmp--;
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
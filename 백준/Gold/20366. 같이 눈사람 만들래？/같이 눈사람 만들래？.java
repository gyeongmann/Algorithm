import java.io.*;
import java.util.*;;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = i + 3; j < N; j++) {
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    int sum = arr[i] + arr[j];
                    int curr = arr[left] + arr[right];

                    ans = Math.min(ans, Math.abs(sum - curr));
                    if (sum > curr) {
                        left++;
                    } else if (sum < curr) {
                        right--;
                    } else {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
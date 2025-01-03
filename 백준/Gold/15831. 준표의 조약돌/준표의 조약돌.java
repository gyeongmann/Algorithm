import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        char[] arr = new char[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = s.charAt(i - 1);
        }
        int[][] prefix = new int[2][N + 1];

        List<Integer> beforeBlack = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (arr[i] == 'B') {
                prefix[0][i] = prefix[0][i - 1] + 1;
                prefix[1][i] = prefix[1][i - 1];
                beforeBlack.add(i - 1);
            } else {
                prefix[0][i] = prefix[0][i - 1];
                prefix[1][i] = prefix[1][i - 1] + 1;
            }
        }
        beforeBlack.add(N);

        int answer = 0;
        int left = 0;
        int right = 0;
        int idx = 0;
        int size = beforeBlack.size();

        while (idx < size) {
            right = beforeBlack.get(idx);

            if (prefix[0][right] - prefix[0][left] <= B) {
                if (prefix[1][right] - prefix[1][left] >= W) {
                    answer = Math.max(answer, right - left);
                }
                idx++;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
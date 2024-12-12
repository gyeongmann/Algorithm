import java.io.*;
import java.util.*;

public class Main {
    static char[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        answer = new char[10][N];
        Arrays.fill(answer[0], 'B');
        
        for (int i = 1; i < 10; i++) {
            Arrays.fill(answer[i], 'B');
            answer[i][0] = 'A';
        }

        f(0, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 8; i++) {
            sb.append(new String(answer[i])).append('\n');
        }
        System.out.println(sb);
    }

    static void f(int start, int end, int depth) {
        if (start + 1 == end) {
            if (answer[depth-1][start] == 'A') answer[depth][start] = 'B';
            else answer[depth][start] = 'A';
            return;
        }

        int mid = start + (end - start) / 2;
        for (int i = start; i < mid; i++) {
            if (answer[depth-1][i] == 'A') answer[depth][i] = 'B';
            else answer[depth][i] = 'A';
        }
        for (int i = mid; i < end; i++) {
            answer[depth][i] = answer[depth-1][i];
        }

        f(start, mid, depth+1);
        f(mid, end, depth+1);
    }
}
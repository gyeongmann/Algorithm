import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean flag;
    static String answer = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        perm(0, new int[N], new boolean[N]);
        if (flag) {
            System.out.println(answer);
            return;
        }

        System.out.println(-1);
    }

    static void perm(int idx, int[] sel, boolean[] vis) {
        if (flag) return;

        if (idx == N) {
            if(isPossible(sel)) {
                flag = true;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (vis[i]) continue;
            vis[i] = true;
            sel[idx] = arr[i];
            perm(idx+1, sel, vis);
            vis[i] = false;
        }
    }

    static boolean isPossible(int[] arr) {
        int[] tmp = new int[2 * N];
        Arrays.fill(tmp, -1);
        for (int i = 0; i < N; i++) {
            int curr = arr[i];
            for (int idx = 0; idx < 2*N; idx++) {
                if (tmp[idx] == -1) {
                    tmp[idx] = curr;
                    int next = idx + curr + 1;
                    if (next >= 2*N) {
                        return false;
                    } else if (tmp[next] != -1) { // 다른 수가 입력되어 있다면
                        return false;
                    } else {
                        tmp[next] = curr;
                    }
                    break;
                }
            }
        }
        for (int x : tmp) {
            answer += x + " ";
        }
        return true;
    }
}
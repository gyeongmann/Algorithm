import java.util.*;
import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        dfs(N, 0);
        System.out.println(min + " " + max);
    }

    private static void dfs(String n, int count) {
        int cnt = 0;
        for (int i = 0; i < n.length(); i++) {
            int curr = n.charAt(i) - '0';
            if (curr % 2 == 1)
                cnt++;
        }

        if (n.length() == 1) {
            min = Math.min(min, count + cnt);
            max = Math.max(max, count + cnt);
            return;
        } else if (n.length() == 2) {
            int a = n.charAt(0) - '0';
            int b = n.charAt(1) - '0';
            dfs(String.valueOf(a + b), count + cnt);
        } else {
            for (int i = 1; i < n.length(); i++) {
                for (int j = i + 1; j < n.length(); j++) {
                    String sub1 = n.substring(0, i);
                    String sub2 = n.substring(i, j);
                    String sub3 = n.substring(j);

                    int num = Integer.parseInt(sub1)
                            + Integer.parseInt(sub2)
                            + Integer.parseInt(sub3);

                    dfs(String.valueOf(num), count + cnt);
                }
            }
        }
    }
}
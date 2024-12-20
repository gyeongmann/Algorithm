import java.util.*;
import java.io.*;

public class Main {
    // static class Lamp implements Comparable<Lamp> {
    //     String line;
    //     int zero;

    //     public Lamp(String line, int zero) {
    //         this.line = line;
    //         this.zero = zero;
    //     }

    //     @Override
    //     public int compareTo(Lamp o) {
    //         return Integer.compare(o.zero, this.zero);
    //     }
    // }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            if (map.containsKey(line)) {
                map.put(line, map.get(line) + 1);
            } else {
                map.put(line, 1);
            }
        }

        // System.out.println(map);
        
        int K = Integer.parseInt(br.readLine());
        int answer = 0;
        for (String key : map.keySet()) {
            int zero = 0;
            for (int i = 0; i < C; i++) {
                if (key.charAt(i) == '0') zero++;
            }

            if (K >= zero && (zero-K)%2 == 0) {
                answer = Math.max(answer, map.get(key));
            }

            // System.out.println(key + " " + zero + " " + answer);
        }

        System.out.println(answer);
    }
}
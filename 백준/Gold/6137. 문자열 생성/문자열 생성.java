import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        // System.out.println("A".compareTo("A")); // 0
        // System.out.println("A".compareTo("B")); // -1
        // System.out.println("B".compareTo("A")); // 1
        StringBuilder sb = new StringBuilder();
        while (!list.isEmpty()) {
            int first = 0;
            int last = list.size() - 1;

            boolean find = false;

            while (first < last) {
                String s = list.get(first);
                String e = list.get(last);
                int compareTo = s.compareTo(e);
                if (compareTo < 0) {
                    find = true;
                    sb.append(list.get(0));
                    list.remove(0);
                    break;
                } else if (compareTo > 0) {
                    find = true;
                    sb.append(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                    break;
                } else {
                    first++;
                    last--;
                }
            }

            if (!find) {
                sb.append(list.get(0));
                list.remove(0);
            }
        }

        String ans = sb.toString();
        while (ans.length() > 80) {
            System.out.println(ans.substring(0, 80));
            ans = ans.substring(80, ans.length());
        }
        System.out.println(ans);
    }
}
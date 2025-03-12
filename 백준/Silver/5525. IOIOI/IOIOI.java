import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String s = br.readLine();
        
        int idx = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < M-1; i++) {
            int cnt = 0;
            if (s.charAt(i) == 'I') {
                i++;
                while (i < M-1) {
                    if (s.charAt(i) == 'O' && s.charAt(i+1) == 'I') {
                        cnt++;
                        i += 2;
                        continue;
                    }
                    
                    break;
                }
                list.add(cnt);
                cnt = 0;
                i--;
            }
        }
        int answer = 0;
        for (int i : list) {
            if (i < N) continue;
            answer += i - N + 1;
        }
        
        System.out.println(answer);
    }
}
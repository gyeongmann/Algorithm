import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        if(N == 1) {
            System.out.println(arr[0]);
            return;
        }
        
        int answer = 0;

        int first = 0;
        int last = N - 1;

        while(first < last) {
            answer += arr[last] * 2;
            first++;
            last--;
        }

        if(first == last) {
            answer += arr[first];
        }

        System.out.println(answer);
    }
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] jewels = new int[N][2];
		boolean[] taken = new boolean[N];
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    jewels[i][0] = Integer.parseInt(st.nextToken());
		    jewels[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        // 보석: 무게 기준 오름차순 정렬
        Arrays.sort(jewels, Comparator.comparingInt(o -> o[0]));
        // 가방: 무게 기준 오름차순 정렬
        Arrays.sort(bags);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long total = 0;
        int jewelIdx = 0;

        for (int i = 0; i < K; i++) {
            int bagCapacity = bags[i];

            // 현재 가방에 담을 수 있는 보석을 우선순위 큐에 추가
            while (jewelIdx < N && jewels[jewelIdx][0] <= bagCapacity) {
                pq.offer(jewels[jewelIdx][1]);
                jewelIdx++;
            }

            // 가장 비싼 보석을 넣는다
            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        System.out.println(total);
	}
}

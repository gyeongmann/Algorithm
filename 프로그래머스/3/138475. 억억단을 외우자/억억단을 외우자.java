import java.util.*;
class Solution {
    public int[] solution(int e, int[] starts) {
        int l = starts.length;
        int[] answer = new int[l];
        
        int[][] dp = new int[e+1][2]; // 약수의 개수
        for (int i = 1; i <= e; i++) {
            dp[i][0] = i;
            for (int j = i; j <= e; j += i) {
                dp[j][1]++;
            }
        }
        
        Arrays.sort(dp, (o1, o2) -> {
            if (o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        });
        
        // for (int[] row : dp) {
        //     System.out.println(Arrays.toString(row));
        // }
        
        for (int i = 0; i < l; i++) {
            int s = starts[i];
            
            for (int[] row : dp) {
                if (s <= row[0]) {
                    answer[i] = row[0];
                    break;
                }
            }
        }
        return answer;
    }
}
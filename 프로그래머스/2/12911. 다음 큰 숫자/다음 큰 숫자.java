import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt = 0;
        int idx = 0;
        int minIdx = 0;
        int[] binary = new int[20];
        
        while (n > 0) {
            if ((n & 1) == 1) {
                binary[idx] = 1;
                cnt++;
                if (cnt == 1) minIdx = idx;
            }
            idx++;
            n >>= 1;
        }
        
        
        // for (int i = 19; i >= 0; i--) {
        //     System.out.print(binary[i] + " ");
        // }
        // System.out.println();
        // System.out.println(cnt);
        
        int origin = cnt;
        // System.out.println(minIdx);
        
        // 1. 마지막 1을 앞에 더하기
        binary[minIdx]--;
        int next = minIdx + 1;
        binary[next]++;
        
        while(binary[next] == 2) {
            binary[next++] = 0;
            binary[next]++;
            cnt--;
        }
        
        // for (int i = 19; i >= 0; i--) {
        //     System.out.print(binary[i] + " ");
        // }
        // System.out.println();
        // System.out.println(cnt);
        
        for (int i = 0; i < origin - cnt; i++) {
            binary[i] = 1;
        }
        
        // for (int i = 19; i >= 0; i--) {
        //     System.out.print(binary[i] + " ");
        // }
        // System.out.println();
        
        int tmp = 1;
        for (int i = 0; i < 20; i++) {
            if ((binary[i] & 1) == 1) {
                answer += tmp;
            }
            tmp <<= 1;
        }
        
        return answer;
    }
}
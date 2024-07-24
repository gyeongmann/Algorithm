import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int width = 2 * w + 1;
        
        int before = 0;
        int next = 0;
        int cnt = 0;
        for (int i = 0; i < stations.length; i++) {
            next = stations[i] - w - 1;
            int dist = next - before;
            
            if (dist > 0) {
                cnt += dist / width + 1;
                if (dist % width == 0) cnt--;
            }
            before = next + w * 2 + 1;
        }
        
        if (before >= n) return cnt;
        cnt += (n - before) / width + 1;
        if ((n - before) % width == 0) cnt--;

        return cnt;
    }
}
import java.util.*;

class Solution {
    class lostRate implements Comparable<lostRate> {
        long idx, x, y;
        
        public lostRate(long idx, long x, long y) {
            this.idx = idx;
            if (y == 0) {
                this.x = 0;
                this.y = 1;
            } else {
                this.x = x;
                this.y = y;
            }
        }
        
        @Override
        public int compareTo(lostRate o) {
            if (this.x * o.y == this.y * o.x) {
                return Long.compare(this.idx, o.idx);
            }
            if (this.x * o.y > this.y * o.x) {
                return -1;
            }
            return 1;
        }
        
        @Override
        public String toString() {
            return "(" + idx + ", " + x + ", " + y + ")";
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int numOfPeople = stages.length;
        long[] counting = new long[N + 2];
        for (int i = 0; i < stages.length; i++) {
            counting[stages[i]]++;
        }
        
        long[] cleared = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            cleared[i] = numOfPeople - counting[i-1];
            numOfPeople -= counting[i-1];
        }
        // System.out.println(Arrays.toString(counting));
        // System.out.println(Arrays.toString(cleared));
        
        lostRate[] arr = new lostRate[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new lostRate(i + 1, counting[i + 1], cleared[i + 1]);
        }
        Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        for (int i = 0; i < N; i++) {
            answer[i] = (int) arr[i].idx;
        }
        return answer;
    }
}
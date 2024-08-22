class Solution {
    long[] c;
    
    public void calMaxConsecutiveSum(int[] s) {
        int n = s.length;
        c = new long[n];
        c[0] = s[0];
        
        for (int i = 1; i < n; i++) {
            c[i] = Math.max(s[i], s[i] + c[i-1]);
        }
    }
    
    public long findMax() {
        long maxSum = Long.MIN_VALUE;
        for (int i = 0; i < c.length; i++) {
            maxSum = Math.max(c[i], maxSum);
        }
        return maxSum;
    }
    
    public int[] changeSequence(int[] s, int val) {
        int n = s.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = s[i] * val;
            val *= -1;
        }
        return res;
    }
    
    public long solution(int[] sequence) {
        long answer = 0;
        int[] s1 = changeSequence(sequence, 1);
        int[] s2 = changeSequence(sequence, -1);
        
        calMaxConsecutiveSum(s1);
        answer = findMax();
        
        calMaxConsecutiveSum(s2);
        answer = Math.max(findMax(), answer);
        return answer;
    }
}
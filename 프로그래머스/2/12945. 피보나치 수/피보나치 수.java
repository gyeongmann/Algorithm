class Solution {
    int[] dp = new int[100001];
    public int solution(int n) {
        dp[0] = 0;
        dp[1] = 1;
        cal(n);
        int answer = dp[n];
        return answer;
    }
    
    void cal(int n) {
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }
    }
}
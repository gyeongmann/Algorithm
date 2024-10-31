class Solution {
    int cnt = 0;
    public int solution(int[] numbers, int target) {      
        dfs(0, 0, numbers, target);
        int answer = cnt;
        return answer;
    }
    
    void dfs(int idx, int curr, int[] numbers, int target) {
        if (idx == numbers.length) {
            if (curr == target) cnt++;
            return;
        }
        
        dfs(idx+1, curr+numbers[idx], numbers, target);
        dfs(idx+1, curr-numbers[idx], numbers, target);
    }
}
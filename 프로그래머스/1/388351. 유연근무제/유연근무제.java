class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int n = schedules.length;
        int answer = n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 7; j++) {
                int today = (startday + j) % 7;
                if (today == 6 || today == 0) continue;
                
                int schedule = schedules[i];
                
                int min = schedule % 100 + 10;
                int hour = schedule / 100 + min / 60;
                min %= 60;
                int time = timelogs[i][j];
                
                if (hour * 100 + min < time) {
                    answer--;
                    break;
                }
            }
        }
        
        return answer;
    }
}
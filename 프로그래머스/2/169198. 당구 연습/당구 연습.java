class Solution {
    
    // 우, 상, 좌, 하
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int l = balls.length;
        int[] answer = new int[l];
        
        for (int i = 0; i < l; i++) {
            int[] curr = balls[i];
            long min = Long.MAX_VALUE;
            
            // 동일 선상에 있는지 체크
            selectDir: for (int dir = 0; dir < 4; dir++) {
                int nx = startX;
                int ny = startY;

                while (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (nx == curr[0] && ny == curr[1]) {
                        continue selectDir;
                    }
                    
                    nx += dx[dir];
                    ny += dy[dir];
                }
                
                // System.out.println(i + " " + dir);
                
                if (dir == 0) { // 오른쪽 대칭
                    nx = 2*m - startX;
                    ny = startY;
                }
                else if (dir == 1) { // 위쪽 대칭
                    nx = startX;
                    ny = 2*n - startY;
                }
                else if (dir == 2) {
                    nx = - startX;
                    ny = startY;
                }
                else if (dir == 3) {
                    nx = startX;
                    ny = - startY;
                }
                
                long tmp = (curr[0] - nx) * (curr[0] - nx) + (curr[1] - ny) * (curr[1] - ny);
                min = Math.min(min, tmp);
            } // selectDir
            answer[i] = (int) min;
        }
                
        return answer;
    }
}
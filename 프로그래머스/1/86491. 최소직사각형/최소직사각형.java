import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int width = 0, height = 0;
        
        for (int[] row : sizes) {
            if (row[0] < row[1]) {
                int tmp = row[0];
                row[0] = row[1];
                row[1] = tmp;
            }
            
            width = Math.max(row[0], width);
            height = Math.max(row[1], height);
        }
        answer = width * height;
        return answer;
    }
}
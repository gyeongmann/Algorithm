import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int cnt = 0;    // A idx
        for(int i = 0; i < B.length; i++ ){
            if(A[cnt] < B[i]){
                answer++;
                cnt++;
            }
        }
        return answer;
    }
}
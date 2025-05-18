import java.util.*;
class Solution {
    public int solution(int[] array) {
        int answer = 0;
        Arrays.sort(array);
        int N = array.length;
        answer = array[N/2];
        return answer;
    }
}
class Solution {
    public int[] solution(int[] num_list) {
        int N = num_list.length;
        int[] answer = new int[N];
        for (int i = N-1; i >= 0; i--) {
            answer[i] = num_list[N-i-1];
        }
        return answer;
    }
}
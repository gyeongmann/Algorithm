class Solution {
    public int[] solution(int brown, int yellow) {
        int A = (brown+4)/2;
        int root = (int) Math.sqrt(A*A-4*(brown + yellow));
        int x = (A + root) / 2;
        int xy = brown + yellow;
        int y = xy / x;
        
        int[] answer = new int[] {x, y};
        return answer;
    }
}
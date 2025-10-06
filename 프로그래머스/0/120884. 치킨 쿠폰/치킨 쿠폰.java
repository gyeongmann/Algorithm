class Solution {
    public int solution(int chicken) {
        int answer = 0;
        int coupon = chicken;
        while (coupon / 10 > 0) {
            int order = coupon / 10;
            coupon %= 10;
            coupon += order;
            answer += order;
        }
        return answer;
    }
}
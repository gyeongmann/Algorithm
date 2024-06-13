import java.util.*;

class Solution {
    static int N, maxCnt, maxCost;
    public int[] solution(int[][] users, int[] emoticons) {
        N = users.length; // 사용자 수
        int[] disCounts = new int[] {40, 30, 20, 10};
        int len = emoticons.length;
        int[] sel = new int[len];
        comb(disCounts, sel, 0, len, emoticons, users);
        
        int[] answer = {maxCnt, maxCost};
        return answer;
    }
    
    // 할인율 조합
    private void comb(int[] arr, int[] sel, int sidx, int len, int[] emoticons, int[][] users) { 
        if (sidx == len) {
            // System.out.print(Arrays.toString(sel) + " ");
            cal(sel, emoticons, len, users);
            // System.out.println();
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            sel[sidx] = arr[i];
            comb(arr, sel, sidx + 1, len, emoticons, users);
        }
    }
    
    private void cal(int[] comb, int[] emoticons, int len, int[][] users) {
        int[] buy = new int[users.length];
        int cnt = 0; // 서비스 가입한 사람
        int buySum = 0;
        for (int i = 0; i < len; i++) {
            int cost = emoticons[i];
            int discount = comb[i];
            int price = cost / 100 * (100 - discount);
            
            for (int idx = 0; idx < users.length; idx++) {
                if (discount >= users[idx][0]) {
                    buy[idx] += price;
                }
            }
            // System.out.print(cost / 100 * (100 - discount) + " ");
        }
        
        for (int i = 0; i < users.length; i++) {
            if (buy[i] >= users[i][1]) {
                cnt++;
                continue;
            }
            buySum += buy[i];
        }
        // System.out.println(Arrays.toString(buy) + " " + cnt + " " + buySum);
        if (cnt > maxCnt) { // 서비스 가입한 사람이 많으면 둘 다 초기화
            maxCnt = cnt;
            maxCost = buySum;
        } else if (cnt == maxCnt) { // 서비스 가입한 사람이 같으면 가격 초기화
            maxCost = Math.max(maxCost, buySum);
        }
    }
}
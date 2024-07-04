import java.util.*;
// import java.io.*;

class Solution {
    int maxCnt = 0;
    int maxLength;
    List<Integer> list;
    List<String> ans = new ArrayList<>();
    // 헉 비트마스킹이다!
    public String[] solution(String[] orders, int[] course) {
        
        
        int[] bit = new int[orders.length];
        for (int idx = 0; idx < orders.length; idx++) {
            String s = orders[idx];
            maxLength = Math.max(s.length(), maxLength);
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 'A';
                ans += 1 << num;
            }
            bit[idx] = ans;
        }
        
        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = i;
        }
        
        for (int c : course) {
            if (maxLength < c) continue;
            maxCnt = 0;
            list = new ArrayList<>();
            comb(c, new int[c], 0, arr, 0, bit);
            // System.out.println(list);
            // System.out.println(maxCnt);
            if (maxCnt >= 2) {
                for (int x : list) {
                    StringBuilder sb = new StringBuilder();
                    String binary = Integer.toBinaryString(x);
                    for (int i = binary.length() - 1; i >= 0; i--) {
                        if (binary.charAt(i) == '1') {
                            char ch = (char) (((int) 'A') + binary.length() - i - 1);
                            // System.out.print(ch);
                            sb.append(ch);
                        }
                    }
                    ans.add(sb.toString());
                    // System.out.println();
                }
            }
        }
        
        Collections.sort(ans);
        System.out.println(ans);
        String[] answer = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            answer[i] = ans.get(i);
        }
        return answer;
    }
    
    private void comb(int size, int[] sel, int sidx, int[] arr, int idx, int[] bits) {
        if (sidx == size) {
            int check = 0;
            int cnt = 0;
            for (int i = 0; i < size; i++) {
                check += 1 << sel[i];
            }
            
            for (int bit : bits) {
                if (check == (check & bit)) cnt++;
            }
            
            if (cnt > maxCnt) {
                list = new ArrayList<>();
                list.add(check);
                maxCnt = cnt;
            }
            else if (cnt == maxCnt) {
                list.add(check);
            }
            return;
        }
        
        if (idx == 26) return;
        
        sel[sidx] = arr[idx];
        comb(size, sel, sidx + 1, arr, idx + 1, bits);
        comb(size, sel, sidx, arr, idx + 1, bits);
    }
}
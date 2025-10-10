import java.util.*;

// 가장 큰 점수 차이 -> 낮은 항목들을 많이 맞춘 경우
class Solution {
    int[] atLeast, apeachShot, answer;
    int max;
    int apeach = 0;
    public int[] solution(int n, int[] info) {
        answer = new int[1];
        atLeast = new int[11];
        apeachShot = info;
        for (int i = 0; i <= 10; i++) {
            atLeast[i] = info[i] + 1;
            if (info[i] > 0) apeach += 10 - i;
        }
        
        // System.out.println(Arrays.toString(atLeast));
        backtracking(n, -1, new ArrayList<>());
        if (answer.length == 1) {
            answer[0] = -1;
        }
        return answer;
    }
    
    void cal(List<Integer> path) {
        int lion = 0;
        int ap = apeach;
        
        for (int s : path) {
            int score = 10 - s;
            lion += score;
            if (apeachShot[s] > 0) {
                ap -= score;
            }
        }
        
        int curr = lion - ap;
        if (curr == 0) return;
        
        if (max < curr) {
            max = curr;
            answer = new int[11];
            for (int i : path) {
                answer[i] = atLeast[i];
            }
        } else if (max == curr) {
            if (answer.length > 1) {
                int[] cand = new int[11];
                for (int i : path) {
                    cand[i] = atLeast[i];
                }
                if (preferLower(answer, cand)) {
                    for (int i = 0; i <= 10; i++) {
                        answer[i] = cand[i];
                    }
                }
            } else {
                answer = new int[11];
                for (int i : path) {
                    answer[i] = atLeast[i];
                }
            }
        }
    }
    
    boolean preferLower(int[] ans, int[] cand) {
        for (int i = 10; i >= 0; i--) {
            if (ans[i] != cand[i]) return ans[i] < cand[i];
        }
        return false;
    }
    
    void backtracking(int n, int idx, List<Integer> path) {
        if (n == 0) {
            cal(path);
            return;
        }
        
        if (n < 0) {
            return;
        }
        
        for (int i = idx + 1; i <= 10; i++) {
            if (i == 10) {
                path.add(i);
                atLeast[i] = n;
                backtracking(n-n, i, path);
                path.remove(path.size() - 1);
            }
            path.add(i);
            backtracking(n-atLeast[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}
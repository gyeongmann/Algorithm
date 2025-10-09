import java.util.*;
class Solution {
    class Node {
        int idx, info;
        List<Integer> child;
        
        public Node(int idx, int info) {
            this.idx = idx;
            this.info = info;
            child = new ArrayList<>();
        }
        
        @Override
        public String toString() {
            return idx + " " + info + " " + child;
        }
    }
    
    Node[] tree;
    int l, answer;
    public int solution(int[] info, int[][] edges) {
        l = info.length;
        tree = new Node[l];
        for (int i = 0; i < l; i++) {
            tree[i] = new Node(i, info[i]);
        }
        
        for (int[] e : edges) {
            int p = e[0]; int ch = e[1];
            tree[p].child.add(ch);
        }
        
        answer = 0;
        backtracking(0, 0, 0, 1, new ArrayList<>(tree[0].child));
        
        return answer;
    }
    
    void backtracking(int idx, int sheep, int wolf, int visited, List<Integer> candidates) {
        int info = tree[idx].info;
        if (info == 0) {
            sheep += 1;
        } else {
            wolf += 1;
        }
        answer = Math.max(answer, sheep);
        
        if (sheep <= wolf) {
            return;
        }
        
        List<Integer> sheepFirst = new ArrayList<>();
        List<Integer> wolvesLater = new ArrayList<>();
        for (int c : candidates) {
            if ((visited & (1 << c)) != 0) continue; // 이미 방문됐으면 스킵
            if (tree[c].info == 0) sheepFirst.add(c);
            else wolvesLater.add(c);
        }
        
        for (int next : sheepFirst) {
            int newVis = visited | (1 << next);
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(Integer.valueOf(next));
            for (int ch : tree[next].child) {
                if ((newVis & (1 << ch)) == 0) nextCandidates.add(ch);
            }
            backtracking(next, sheep, wolf, newVis, nextCandidates);
        }
        
        for (int next : wolvesLater) {
            int newVis = visited | (1 << next);
            List<Integer> nextCandidates = new ArrayList<>(candidates);
            nextCandidates.remove(Integer.valueOf(next));
            for (int ch : tree[next].child) {
                if ((newVis & (1 << ch)) == 0) nextCandidates.add(ch);
            }
            backtracking(next, sheep, wolf, newVis, nextCandidates);
        }
    }
}
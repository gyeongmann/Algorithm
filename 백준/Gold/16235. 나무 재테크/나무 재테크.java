import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;

    static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

    static class Tree implements Comparable<Tree> {
        int r, c, age;

        Tree() {
        }

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        private boolean eat(int food) {
            if (food >= age) {
                age++;
                return true;
            }
            return false;
        }

        @Override
        public String toString() {
            return r + " " + c + " " + age;
        }

        @Override
        public int compareTo(Tree o) {
            return Integer.compare(this.age, o.age);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine()); // N, M, K
        int N = Integer.parseInt(st.nextToken()); // 땅 크기
        int M = Integer.parseInt(st.nextToken()); // M개의 나무
        int K = Integer.parseInt(st.nextToken()); // K년 후

        map = new int[N + 1][N + 1];
        for (int[] row : map) {
            Arrays.fill(row, 5);
        }

        int[][] A = new int[N + 1][N + 1]; // 겨울에 추가되는 양분의 양
        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(in.readLine());
            for (int c = 1; c <= N; c++) {
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        } // input

        PriorityQueue<Tree> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(in.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            pq.add(new Tree(r, c, age));
        }

        Queue<Tree> alive = new LinkedList<>();
        Queue<Tree> dead = new LinkedList<>();
        for (int year = 1; year <= K; year++) {
            // 봄
            while (!pq.isEmpty()) {
                Tree curr = pq.poll();
                int r = curr.r;
                int c = curr.c;
                int age = curr.age;
                int food = map[r][c];
                if (curr.eat(food)) {
                    map[r][c] -= age;
                    alive.add(curr);
                } else {
                    dead.add(curr);
                }
            }

            // 여름
            while (!dead.isEmpty()) {
                Tree tree = dead.poll();
                int r = tree.r;
                int c = tree.c;
                int age = tree.age;
                map[r][c] += age / 2;
            }

            // 가을
            while (!alive.isEmpty()) {
                Tree tree = alive.poll();
                int r = tree.r;
                int c = tree.c;
                int age = tree.age;

                if (age % 5 == 0) {
                    for (int dir = 0; dir < 8; dir++) {
                        int nr = r + dr[dir];
                        int nc = c + dc[dir];
                        if (nr <= 0 || nc <= 0 || nr > N || nc > N) {
                            continue;
                        }
                        pq.add(new Tree(nr, nc, 1));
                    }
                }
                pq.add(tree);
            }

            // 겨울
            for (int r = 1; r <= N; r++) {
                for (int c = 1; c <= N; c++) {
                    map[r][c] += A[r][c];
                }
            }
        } // calculate
        
        System.out.println(pq.size());
//        System.out.println(pq);
    } // main
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isRow = {true, false};
    static boolean[] diagDir = {true, false}; // 우하, 우상
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String[][] board = new String[3][3];
            for (int i = 0; i < 3; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    board[i][j] = st.nextToken();
                }
            }
            
            Set<String> vis = new HashSet<>();;
            Queue<String[][]> q = new LinkedList<>();
            q.offer(board);

            String s = "";
            for (String[] row : board) {
                s += Arrays.toString(row);
            }
            vis.add(s);

            int depth = 0;
            boolean find = false;
            // System.out.println(tc + " ---------------");
            bfs: while(!q.isEmpty()) {
                int size = q.size();
                
                for (int i = 0; i < size; i++) {
                    String[][] curr = q.poll();

                    // for (String[] row : curr) {
                    //     System.out.println(Arrays.toString(row));
                    // }
                    // System.out.println("-------------------");
                    
                    if (check(curr)) {
                        find = true;
                        break bfs;
                    }
                    for (int j = 0; j < 2; j++) {
                        for (int idx = 0; idx < 3; idx++) {
                            String[][] nBoard = change(curr, isRow[j], idx);
                            s = "";
                            for (String[] row : nBoard) {
                                s += Arrays.toString(row);
                            }

                            if (vis.contains(s)) continue;
                            q.offer(nBoard);
                            vis.add(s);
                        }
                        
                        String[][] nBoard = diagChange(curr, diagDir[j]);
                        s = "";
                        for (String[] row : nBoard) {
                            s += Arrays.toString(row);
                        }

                        if (vis.contains(s)) continue;
                        q.offer(nBoard);
                        vis.add(s);
                    }
                }
                depth++;
            }

            if (find) {
                // System.out.println(depth);
                sb.append(depth).append('\n');
            } else {
                // System.out.println(-1);
                sb.append(-1).append('\n');
            }
        }
        System.out.print(sb);
    }

    static boolean check(String[][] board) {
        String s = board[0][0];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board[i][j].equals(s)) return false;
            }
        }

        return true;
    }

    static String[][] change(String[][] board, boolean isRow, int idx) {
        String[][] nBoard = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nBoard[i][j] = board[i][j];
            }
        }

        if (isRow) {
            for (int j = 0; j < 3; j++) {
                if (nBoard[idx][j].equals("H")) {
                    nBoard[idx][j] = "T";
                } else {
                    nBoard[idx][j] = "H";
                }
            }
        } else {
            for (int j = 0; j < 3; j++) {
                if (nBoard[j][idx].equals("H")) {
                    nBoard[j][idx] = "T";
                } else {
                    nBoard[j][idx] = "H";
                }
            }
        }

        return nBoard;
    }

    static String[][] diagChange(String[][] board, boolean diagDir) {
        String[][] nBoard = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nBoard[i][j] = board[i][j];
            }
        }

        if (diagDir) {
            for (int i = 0; i < 3; i++) {
                if (nBoard[i][i].equals("H")) {
                    nBoard[i][i] = "T";
                } else {
                    nBoard[i][i] = "H";
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                if (nBoard[i][2-i].equals("H")) {
                    nBoard[i][2-i] = "T";
                } else {
                    nBoard[i][2-i] = "H";
                }
            }
        }

        return nBoard;
    }
}
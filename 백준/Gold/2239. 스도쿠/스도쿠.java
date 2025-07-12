import java.util.*;
import java.io.*;

public class Main {
	static int[][] map = new int[9][9];
	static List<int[]> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
		    String line = br.readLine();
		    for (int j = 0; j < 9; j++) {
		        map[i][j] = line.charAt(j) - '0';
		        if (map[i][j] == 0) list.add(new int[] {i, j});
		    }
		}
		
		dfs(0);
	}
	
	static void dfs(int depth) {
	    if (depth >= list.size()) {
	        for (int i = 0; i < 9; i++) {
	            for (int j = 0; j < 9; j++) {
	                System.out.print(map[i][j]);
	            }
	            System.out.println();
	        }
	        System.exit(0);
	    }
	    
	    int[] curr = list.get(depth);
	    for (int i = 1; i <= 9; i++) {
	        boolean check = false;
	        // 가로, 세로
	        for (int c = 0; c < 9; c++) {
	            if (map[curr[0]][c] == i || map[c][curr[1]] == i) {
	                check = true;
	            }
	        }
	        
	        // 같은 칸칸
	        int rs = curr[0] - curr[0]%3;
	        int cs = curr[1] - curr[1]%3;
	        for (int r = 0; r < 3; r++) {
	            for (int c = 0; c < 3; c++) {
	                if (map[rs + r][cs + c] == i) {
	                    check = true;
	                }
	            }
	        }
	        
	        if(!check) {
	            map[curr[0]][curr[1]] = i;
	            dfs(depth+1);
	            map[curr[0]][curr[1]] = 0;
	        }
	    }
	}
}

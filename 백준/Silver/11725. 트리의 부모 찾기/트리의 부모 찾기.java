import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	static List<Integer>[] adj;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(in.readLine());
		
		adj = new ArrayList[N + 1];
		p = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			adj[a].add(b);
			adj[b].add(a);
		}
		
		makeTree(1, -1);
		for (int i = 2; i <= N; i++) {
			System.out.println(p[i]);
		}
	}
	
	private static void makeTree(int currNode, int parent) {
		for (Integer i : adj[currNode]) {
			if (i != parent) {
				p[i] = currNode;
				makeTree(i, currNode);
			}
		}
	}
}

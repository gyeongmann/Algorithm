import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
// 		System.out.println(H + " " + W + " " + N + " " + M);
		int h = H / (N+1);
		int w = W / (M+1);
		
// 		System.out.println(H % (N+1));
		if (H % (N+1) > 0) h++;
		if (W % (M+1) > 0) w++;
		
		System.out.println(h * w);
	}
}

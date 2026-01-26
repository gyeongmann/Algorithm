import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    
	    int N = Integer.parseInt(br.readLine());
	    double[] scores = new double[N];
	    
	    double M = 0;
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    for (int i = 0; i < N; i++) {
	         double num = Double.parseDouble(st.nextToken());
	         M = Math.max(M, num);
	         scores[i] = num;
	    }
	    
	    double sum = 0;
	    for (int i = 0; i < N; i++) {
	        sum += (double) (scores[i]/M * 100);
	    }
	    
	    System.out.println(sum/N);
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int[] S = new int[N+1];
	    for (int i = 1; i <= N; i++) {
	        S[i] = i + S[i-1];
	    }
	    
	    int start = 0;
	    int end = 1;
	    int answer = 0;
	    while (end <= N) {
	        if (S[end] - S[start] > N) {
	            start++;
	        } else if (S[end] - S[start] == N) {
	            answer++;
	            end++;
	        } else {
	            end++;
	        }
	    }
	    
	    System.out.println(answer);
	}
}

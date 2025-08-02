import java.util.*;

public class Main
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    StringTokenizer st;
	    
	    int[] A = new int[2];
	    int[] B = new int[2];
	    st = new StringTokenizer(sc.nextLine());
	    for (int i = 0; i < 2; i++) {
	        A[i] = Integer.parseInt(st.nextToken());
	    }
	    for (int i = 0; i < 2; i++) {
	        B[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    int[] C = new int[2];
	    int[] D = new int[2];
	    st = new StringTokenizer(sc.nextLine());
	    for (int i = 0; i < 2; i++) {
	        C[i] = Integer.parseInt(st.nextToken());
	    }
	    for (int i = 0; i < 2; i++) {
	        D[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    if (!isIntersect(A, B, C, D)) {
	        System.out.println(0);
	        return;
	    }
	    
	    if (!checkArea(A, B, C, D)) {
	        System.out.println(0);
	        return;
	    }
	    
	    System.out.println(1);
	}
	
	static boolean isIntersect(int[] A, int[] B, int[] C, int[] D) {
        int ab = ccw(A, B, C) * ccw(A, B, D);
        int cd = ccw(C, D, A) * ccw(C, D, B);

        return ab <= 0 && cd <= 0;
    }
	
	static int ccw(int[] a, int[] b, int[] c) {
        long op = 1L * (b[0] - a[0]) * (c[1] - a[1]) - 1L * (b[1] - a[1]) * (c[0] - a[0]);
        if (op > 0) return 1;    // counter-clockwise
        if (op < 0) return -1;   // clockwise
        return 0;                // colinear
    }
	
	static boolean checkArea(int[] A, int[] B, int[] C, int[] D) {
	    if (Math.max(A[0], B[0]) >= Math.min(C[0], D[0]) && Math.min(A[0], B[0]) <= Math.max(C[0], D[0])
	        && Math.max(A[1], B[1]) >= Math.min(C[1], D[1]) && Math.min(A[1], B[1]) <= Math.max(C[1], D[1])) {
	            return true;
        }
        return false;
	}
}
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        if (first.length() != second.length()) {
	        return false;
	    }
	    
	    char[] arr1 = first.toCharArray();
	    char[] arr2 = second.toCharArray();
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    
	    for (int i = 0; i < arr1.length; i++) {
	        if (arr1[i] != arr2[i]) {
	            return false;
	        }
	    }
	    
	    return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}

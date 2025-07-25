import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append('*');
        }
        
        String str = sb.toString();
        for (int i = 0; i < N; i++) {
            System.out.println(str);
            str = str.substring(0, N-i-1);
        }
    }
}
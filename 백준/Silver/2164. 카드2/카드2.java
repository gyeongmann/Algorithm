import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> q = new LinkedList<>();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            q.add(i + 1);
        }

        while (q.size() > 1) {
            q.removeFirst();
            q.add(q.getFirst());
            q.removeFirst();
        }

        System.out.println(q.getFirst());
    }
}

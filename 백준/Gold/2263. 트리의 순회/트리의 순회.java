import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] inorder;
    static int[] postorder;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        
        inorder = new int[n];
        postorder = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        
        find(0, n-1, 0, n-1);
        
        System.out.println(sb.toString());
    }

    public static void find(int startIn, int endIn, int startPost, int endPost) {
        if (startIn > endIn || startPost > endPost) return;
        if (startIn == endIn) {
            sb.append(inorder[startIn] + " ");
            return;
        }
        
        int root = postorder[endPost];
        sb.append(root + " ");
        
        int rootIdx = 0;
        for (rootIdx = startIn; rootIdx <= endIn; rootIdx++) {
            if (inorder[rootIdx] == root) {
                break;
            }
        }
        
        int leftSize = rootIdx - startIn;
        
        find(startIn, rootIdx-1, startPost, startPost + leftSize - 1);
        find(rootIdx + 1, endIn, startPost + leftSize, endPost - 1);
    }
}
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    StringBuilder sb = new StringBuilder();
	    int N = Integer.parseInt(br.readLine());
	    
	    int[][] ips= new int[N][4];
	    for (int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine(), ".");
	        for (int j = 0; j < 4; j++) {
	            ips[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    int[] ipInts = new int[N];
        for (int i = 0; i < N; i++) {
            int ip = 0;
            for (int j = 0; j < 4; j++) {
                ip = (ip << 8) | ips[i][j];
            }
            ipInts[i] = ip;
        }
        
        int min = ipInts[0], max = ipInts[0];
        for (int i = 1; i < N; i++) {
            min = Math.min(min, ipInts[i]);
            max = Math.max(max, ipInts[i]);
        }
        
        int diff = min ^ max;
        
        int m = 0;
        for (int i = 31; i >= 0; i--) {
            if (((diff >> i) & 1) == 1) {
                m = i+1;
                break;
            }
        }
        
        int[] mask = {255, 255, 255, 255};
        if (m <= 8) {
            mask[3] = 255 - ((1 << m) - 1);
        } else if (m <= 16) {
            int x = m - 8;
            mask[3] = 0;
            mask[2] = 255 - ((1 << x) - 1);
        } else if (m <= 24) {
            int x = m - 16;
            mask[3] = 0;
            mask[2] = 0;
            mask[1] = 255 - ((1 << x) - 1);
        } else {
            int x = m - 24;
            mask[3] = 0;
            mask[2] = 0;
            mask[1] = 0;
            mask[0] = 255 - ((1 << x) - 1);
        }
        
        int[] address = new int[4];
        for (int i = 0; i < 4; i++) {
            address[i] = mask[i];
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                address[j] = address[j] & ips[i][j];
            }
        }
        
        for (int i = 0; i < 3; i++) {
            sb.append(address[i]).append('.');
        }
        sb.append(address[3]).append('\n');
        for (int i = 0; i < 3; i++) {
            sb.append(mask[i]).append('.');
        }
        sb.append(mask[3]).append('\n');
        System.out.println(sb.toString());
        return;
	}
}
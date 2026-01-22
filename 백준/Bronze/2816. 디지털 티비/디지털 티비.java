import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] channelList = new String[N];
		
		int firstIdx = -1;
		for (int i = 0; i < N; i++) {
		    String s = br.readLine().trim();
		    channelList[i] = s;
		    
		    if (s.equals("KBS1")) {
		        firstIdx = i;
		    }
		}
		
		StringBuilder sb = new StringBuilder();
		int currIdx = 0;
		for (int i = 0; i < firstIdx; i++) {
		    sb.append(3);
		    currIdx = downChange(currIdx, channelList);
		}
		
		if (!channelList[0].equals("KBS1")) {
		    sb.append(2);
		    currIdx = up(currIdx);
		    for (int i = 0; i < firstIdx - 1; i++) {
		        sb.append(4);
		        currIdx = upChange(currIdx, channelList);
		    }
		}
		
		int secondIdx = -1;
		for (int i = 1; i < N; i++) {
		    if (channelList[i].equals("KBS2")) {
		        secondIdx = i;
		    }
		}
		
		if (!channelList[1].equals("KBS2")) {
		    int s = currIdx;
		    for (int i = s; i < secondIdx; i++) {
		        sb.append(1);
		        currIdx = down(currIdx, N);
		    }
		    
		    for (int i = 1; i < secondIdx; i++) {
		        sb.append(4);
		        currIdx = upChange(currIdx, channelList);
		    }
		}
		
		System.out.println(sb.toString());
	}
	
	// 1
	private static int down(int idx, int N) {
	    if (idx == N-1) return idx;
	    return ++idx;
	}
	
	// 2
	private static int up(int idx) {
	    if (idx == 0) return idx;
	    return --idx;
	}
	
	// 3
	private static int downChange(int idx, String[] list) {
	    if (idx == list.length-1) return idx;
	    swap(idx, idx+1, list);
	    return ++idx;
	}
	
	// 4
	private static int upChange(int idx, String[] list) {
	    if (idx == 0) return idx;
	    swap(idx, idx-1, list);
	    return --idx;
	}
	
	private static void swap(int i, int j, String[] list) {
	    String tmp = list[i];
	    list[i] = list[j];
	    list[j] = tmp;
	}
}
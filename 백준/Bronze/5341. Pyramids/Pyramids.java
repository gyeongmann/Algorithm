import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String line;
		
		while (!(line = in.readLine()).equals("0")) {
			int n = Integer.parseInt(line);
			sb.append(n * (n + 1) / 2).append('\n');
		}
		
		System.out.println(sb);
	}
}

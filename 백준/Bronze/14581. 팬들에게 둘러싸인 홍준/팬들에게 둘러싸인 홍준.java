import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		System.out.printf(":fan::fan::fan:\n"
				+ ":fan::%s::fan:\n"
				+ ":fan::fan::fan:", s);
	}
}

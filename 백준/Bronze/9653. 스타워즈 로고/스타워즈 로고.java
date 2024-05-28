import java.util.Scanner;

public class Main {
	static String out = "    8888888888  888    88888\r\n"
			+ "   88     88   88 88   88  88\r\n"
			+ "    8888  88  88   88  88888\r\n"
			+ "       88 88 888888888 88   88\r\n"
			+ "88888888  88 88     88 88    888888\r\n"
			+ "\r\n"
			+ "88  88  88   888    88888    888888\r\n"
			+ "88  88  88  88 88   88  88  88\r\n"
			+ "88 8888 88 88   88  88888    8888\r\n"
			+ " 888  888 888888888 88  88      88\r\n"
			+ "  88  88  88     88 88   88888888";
	public static void main(String[] args) {
		Scanner sc = new Scanner(out);
		String line;
		while (sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
	}
}

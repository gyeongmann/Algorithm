import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static class Person implements Comparable<Person> {
		int age;
		String name;

		public Person(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(in.readLine());
		Person[] arr = new Person[n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			Person person = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
			arr[i] = person;
		}
		Arrays.sort(arr);
		for (Person p : arr) {
			System.out.println(p.age + " " + p.name);
		}
	}
}

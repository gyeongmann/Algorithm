import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Map<String, Boolean> map = new HashMap<>();
		int n = Integer.parseInt(in.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			String name = st.nextToken();
			String status = st.nextToken();
			if (status.equals("enter")) {
				map.put(name, true);
			} else {
				map.remove(name);
			}
		}
		
		List<String> names = new ArrayList<>();
		for (String name : map.keySet()) {
			names.add(name);
		}
		names.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		for (String name : names) {
			System.out.println(name);
		}
	}
}

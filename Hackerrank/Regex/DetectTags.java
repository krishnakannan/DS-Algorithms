
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DetectTags {
	static final Pattern PATTERN = Pattern
			.compile("<(\\w+)\\s*\\w*[^<]*>", Pattern.MULTILINE);

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		sc.nextLine();
		String html = readHtml(sc, N);
		SortedSet<String> tagSet = new TreeSet<>();
		Matcher matcher = PATTERN.matcher(html);
		while (matcher.find()) {
			String tag = matcher.group(1).trim();			
			tagSet.add(tag);
		}
		int count = 1;
		for (String tag : tagSet) {
			System.out.print(tag);
			if (tagSet.size() > count) {
				System.out.print(";");	
			}
			count++;			
		}		
		sc.close();
	}

	static String readHtml(Scanner sc, int N) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(sc.nextLine());
		}
		return sb.toString();
	}
}
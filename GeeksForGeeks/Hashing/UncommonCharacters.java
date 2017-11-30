import java.util.*;
import java.lang.*;
import java.io.*;

//https://practice.geeksforgeeks.org/problems/uncommon-characters/0

class UncommonCharacters {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		UncommonCharacters uncommonCharactersObj = new UncommonCharacters();
		while (--testcases >= 0) {
		    String str1 = in.next();		
		    String str2 = in.next();
		    System.out.println(uncommonCharactersObj.getUncommonChars(str1, str2));
 		}
	}

	public String getUncommonChars(String s1, String s2) {
		Map<Character, Integer> map = new HashMap<>();
		int s1Len = s1.length();
		int s2Len = s2.length();
		for (int i = 0; i < s1Len; i++) {
			map.put(s1.charAt(i), 0);
		}		
		for (int i = 0; i < s2Len; i++) {
			if (map.containsKey(s2.charAt(i)) && map.get(s2.charAt(i)) == 0) {
				map.put(s2.charAt(i), -1);
			} else if (map.containsKey(s2.charAt(i)) && map.get(s2.charAt(i)) == -1) {
				map.put(s2.charAt(i), -1);
			} else {
				map.put(s2.charAt(i), 1);
			}
		}		
		List<Character> uncommon = new ArrayList<>();
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() == 1 || entry.getValue() == 0) {
				uncommon.add(entry.getKey());
			}
		}
		Collections.sort(uncommon);
		StringBuilder sBuilder = new StringBuilder();
		for (Character x : uncommon) {
			sBuilder.append(x);
		}
		return sBuilder.toString();
	}
}
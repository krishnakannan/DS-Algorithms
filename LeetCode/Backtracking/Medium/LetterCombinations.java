import java.util.*;
import java.lang.*;
import java.io.*;

class LetterCombinations {
	Map<Character, String> digitMap;
	List<String> combinations;

	//Instance initialization block
	{
		digitMap = new HashMap<>();
		digitMap.put('2',"abc");
		digitMap.put('3',"def");
		digitMap.put('4',"ghi");
		digitMap.put('5',"jkl");
		digitMap.put('6',"mno");
		digitMap.put('7',"pqrs");
		digitMap.put('8',"tuv");
		digitMap.put('9',"wxyz");
		combinations = new ArrayList<>();
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		LetterCombinations lCombinations = new LetterCombinations();
		while (--testcases >= 0) {
		    String str = in.next();		
		    System.out.println(lCombinations.letterCombinations(str));
 		}
	}

    public List<String> letterCombinations(String digits) {
    	if (digits.isEmpty()) {
    		return combinations;
    	}
    	List<Character[]> alphabets = getAlphabets(digits);

		combine(alphabets, 0, new StringBuilder(), digits.length());    	

    	return combinations;
    }

    public void combine(List<Character[]> alphabets, int listIndex, StringBuilder formed, int expectedLength) {

    	//One more level to add it to the Global List
    	if (formed.length() == expectedLength) {
    		combinations.add(formed.toString());
    		return;
    	}

    	//Final Alphabet
    	if (formed.length() == expectedLength - 1) {
    		Character[] currentAlphabets = alphabets.get(listIndex);
    		for (int i = 0; i < currentAlphabets.length; i++) {
    			formed.append(currentAlphabets[i]);
    			combine(alphabets, listIndex, formed, expectedLength);
    			formed.setLength(formed.length() - 1);
    		}
    		return;
    	}
    	

    	for (int i = listIndex; i < alphabets.size() - 1; i++) {
    		Character[] currentAlphabets = alphabets.get(i);
    		for (int j = 0; j < currentAlphabets.length; j++) {
    			formed.append(currentAlphabets[j]);
    			combine(alphabets, i + 1, formed, expectedLength);
    			formed.setLength(formed.length() - 1);
    		}
    	}


    }

    public List<Character[]> getAlphabets(String digits) {
    	List<Character[]> alphabets = new ArrayList<>();
    	for (int i = 0; i < digits.length(); i++) {
    		alphabets.add(getSingleAlphabet(digits.charAt(i)));
    	}
    	return alphabets;
    }

    public Character[] getSingleAlphabet(Character digit) {
    	String chars = digitMap.get(digit);
    	int length = chars.length();
    	Character[] arr = new Character[length];
    	for (int i = 0; i < length; i++) {
    		arr[i] = chars.charAt(i);
    	}
    	return arr;
    }
}
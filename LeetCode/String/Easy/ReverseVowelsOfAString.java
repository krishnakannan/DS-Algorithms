public class Solution {
    public String reverseVowels(String s) {
        ArrayList<Character> vowels = new ArrayList<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Character> vowelsInString = new ArrayList<>();
        int index = 0;
        int length = s.length();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
        	if (vowels.contains(s.charAt(i))) {
        		vowelsInString.add(index, s.charAt(i));
        		index++;
        	}
        }
        index--;
        for (int i = 0; i < length; i++) {
        	if (vowels.contains(s.charAt(i))) {
        		sb.append(vowelsInString.get(index));
        		index--;
        	} else {
        		sb.append(s.charAt(i));
        	}

        }

        return sb.toString();    
    }
}
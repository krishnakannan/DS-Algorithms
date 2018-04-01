public class Solution {
    public String[] findWords(String[] words) {
        ArrayList<Character> firstRow = new ArrayList<>(Arrays.asList(new Character[] {'q','Q','w','W','e','E','r','R','t','T','y','Y','u','U','i','I','o','O','p','P'}));
        ArrayList<Character> secondRow = new ArrayList<>(Arrays.asList(new Character[] {'a','A','s','S','d','D','f','F','g','G','h','H','j','J','k','K','l','L'}));
        ArrayList<Character> thirdRow = new ArrayList<>(Arrays.asList(new Character[] {'z','Z','x','X','c','C','v','V','b','B','n','N','m','M'}));
        ArrayList<String> output = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
        	
        	if (firstRow.contains(words[i].charAt(0))) {
        		if (isInARow(firstRow, words[i])) {
        			output.add(words[i]);
        		}
        	}
        	if (secondRow.contains(words[i].charAt(0))) {
        		if (isInARow(secondRow, words[i])) {
        			output.add(words[i]);
        		}	
        	}
        	if (thirdRow.contains(words[i].charAt(0))) {
        		if (isInARow(thirdRow, words[i])) {
        			output.add(words[i]);
        		}
        	}

        }
        return output.toArray(new String[output.size()]);   
    }
    
    public boolean isInARow(ArrayList<Character> list, String word) {
    	int wordLength = word.length();
    	for (int j = 0; j < wordLength; j++) {
			if (list.contains(word.charAt(j))) {
        		continue;
        	} else {
        		return false;
        	}
        }
        return true;
    }
}
import java.util.*;
import java.lang.*;
import java.io.*;

/*
	This solution doesn't work if the word contains a Number (But passed all Leetcode testcases)
*/


class GeneralizedAbbreviation {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String word = in.next();
		GeneralizedAbbreviation ga = new GeneralizedAbbreviation();
		System.out.println(ga.generateAbbreviations(word));
		//System.out.println(ga.filterString(word.toCharArray()));
	}

	List<String> generated = new ArrayList<>();

    public List<String> generateAbbreviations(String word) {
    	generate(word.toCharArray(), 0);
    	return generated;
    }


    public void generate(char[] word, int index) {

    	if (index > word.length) {
    		return;
    	}

    	generated.add(filterString(word));

    	for (int i = index; i < word.length; i++) {
    		char temp = word[i];
    		word[i] = '1';
    		generate(word, i + 1);
    		word[i] = temp;
    	}

    }

    public String filterString(char[] current) {
    	StringBuilder sBuilder = new StringBuilder();
    	int index = 0;
    	int temp = 0;
    	while (index < current.length) {
    		if (current[index] > '0' && current[index] <= '9') {
    			temp += current[index] - '0';    			
    		} else {
    			if (temp > 0) {
    				sBuilder.append(temp);
    				sBuilder.append(current[index]);
    				temp = 0;
    			} else {
    				sBuilder.append(current[index]);
    			}
    		}
    		index++;
    	}

    	if (temp > 0) {
    		sBuilder.append(temp);
    	}
    	return sBuilder.toString();
    }


}
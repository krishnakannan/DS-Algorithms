import java.util.*;
import java.lang.*;
import java.io.*;

class TextJustification {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		TextJustification tj = new TextJustification();
		int n = in.nextInt();
		String[] words = new String[n];
		for (int i = 0; i < n; i++) {
			words[i] = in.next();
		}
		int maxWidth = in.nextInt();
		List<String> justified = tj.fullJustify(words, maxWidth);
		for (String justifiedLine : justified) {
			System.out.println(justifiedLine);
		}
	}

	int index = 0;
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justified = new ArrayList<>();                
        while (index < words.length) {
        	justified.add(getJustifiedLine(words, maxWidth));
        }
        return justified;
    }

    public String getJustifiedLine(String[] words, int maxWidth) {
    	int currentWidth = 0;    	
    	int wordCount = 0;
    	int start = index;    	
    	StringBuilder formed = new StringBuilder();
    	boolean hasAdded = false;
    	while (index < words.length) {
    		currentWidth += words[index].length();
    		wordCount += 1;
    		index++;
    		// System.out.println("currentWidth " + currentWidth + " words " + wordCount + " spaces " + (wordCount - 1));
    		if ((currentWidth + wordCount - 1) >= maxWidth) {
    			if ((currentWidth + wordCount - 1) > maxWidth) {
    				index--;
    				currentWidth -= words[index].length();
    				wordCount -= 1;    				
    			}    			       			
    			int spacesAvailable = maxWidth - currentWidth;
    			int slotsAvailable = wordCount - 1;
    			int spaceSize = slotsAvailable == 0 ? maxWidth - currentWidth : (spacesAvailable + 1) / slotsAvailable;    		
                int spill = spacesAvailable - (spaceSize * slotsAvailable);
    			while (start < index) {    				
					formed.append(words[start]);
					start++;
					if (spacesAvailable > spaceSize) {
                        if (spill > 0) {
                            formed.append(getSpaces(spaceSize + 1));	    
                            spill--;
                            spacesAvailable -= 1;
                        } else {
                            formed.append(getSpaces(spaceSize));	    
                        }
                    } else {
                        formed.append(getSpaces(spacesAvailable));
                    }    					
                    spacesAvailable -= spaceSize;    
					
				}
				hasAdded = true; 			            
    			break;
    		}
    	}

    	if (!hasAdded) {
    		int spacesAvailable = maxWidth - currentWidth;
    		int slotsAvailable = index - start - 1;
    		int spaceSize = slotsAvailable == 0 ? maxWidth - currentWidth : (spacesAvailable + 1) / slotsAvailable;    
            int wCount = index - start;
    		while (start < index) {    			
    			formed.append(words[start]);
    			start++;
                formed.append(" ");
    		}
            formed.append(getSpaces(maxWidth - formed.length()));
    		
    	}    	
    	
    	return formed.toString();
    }

    public String getSpaces(int count) {
    	StringBuilder s = new StringBuilder();
    	while (--count >= 0) {
    		s.append(" ");
    	}
    	return s.toString();
    }
}
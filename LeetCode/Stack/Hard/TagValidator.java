import java.util.*;
import java.lang.*;
import java.io.*;

class TagValidator {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String code = in.nextLine();
		TagValidator tv = new TagValidator();
		System.out.println(tv.isValid(code));
	}

	class Tag {
		String tagName;
		boolean isOpen;
		public Tag(String tagName, boolean isOpen) {
			this.tagName = tagName;
			this.isOpen = isOpen;
		}
	}

	char[] cdataStart = new char[]{'<','!','[','C','D','A','T','A','['};

	int index = 0;
	boolean isValidCode = true;

    public boolean isValid(String code) {
        
    	char[] codeArray = code.toCharArray();

    	int tagCount = 0;
    	Stack<Tag> tagStack = new Stack<>();

        while (index < codeArray.length) {        	
        	if (index < codeArray.length - 1 && codeArray[index] == '<' && codeArray[index + 1] == '!') {        
        		processCdata(codeArray);
        	} else if (codeArray[index] == '<') {
        		tagCount += 1;
        		Tag tag = getTag(codeArray);
        		if (tagStack.isEmpty()) {
        			tagStack.push(tag);
        		} else if (tagStack.peek().tagName.equals(tag.tagName)) {
        			if (tagStack.peek().isOpen && !tag.isOpen) {
        				tagStack.pop();
        			} else {
        				tagStack.push(tag);
        			}
        		} else {
        			tagStack.push(tag);
        		}
        	} else {
        		index += 1;
        	}
            if (tagStack.isEmpty()) {
                if (index < codeArray.length - 1) {
                    isValidCode = false;
                }
            }
        	if (!isValidCode) {
        		break;
        	}            
        }
		// printStack(tagStack);
        return isValidCode && tagCount > 0 && tagStack.isEmpty();
    }

    public Tag getTag(char[] code) {
    	StringBuilder builder = new StringBuilder();    	
    	index += 1;
    	if (index >= code.length) {
    		isValidCode = false;
    		return new Tag("", false);    		
    	}
    	boolean isOpen = true;
    	if (code[index] == '/') {    		
    		isOpen = false;
    		index += 1;
    	}
    	while (index < code.length) {
    		if (code[index] >= 'A' && code[index] <= 'Z') {
    			builder.append(code[index]);
    		} else {
    			if (code[index] != '>') {    				
    				isValidCode = false;    				
    			}
    			break;
    		}    		
    		index += 1;
    	}

    	if (index == code.length) {
    		if (code[index - 1] != '>') {
    			isValidCode = false;
    		}
    	}
        if (builder.length() < 1 || builder.length() > 9) {
            isValidCode = false;
        }
    	return new Tag(builder.toString(), isOpen);
    }

    public void processCdata(char[] code) {

    	int csIndex = 0;
    	while (index < code.length && csIndex < cdataStart.length) {
    		if (code[index] != cdataStart[csIndex]) {
    			isValidCode = false;
    			return;
    		}
    		csIndex += 1;
    		index += 1;
    	}

    	while (index < code.length) {    	
    		if (index < code.length - 2 && code[index] == ']' &&  code[index + 1] == ']' && code[index + 2] == '>') {    			
    			index += 2;
    			return;
    		}
    		index += 1;
    	}
    	isValidCode = false;

    }

    public void printStack(Stack<Tag> stack) {
    	for (Tag tag : stack) {
    		System.out.println(tag.tagName + " => " + (tag.isOpen ? "Open" : "Close"));
    	}
    }
}
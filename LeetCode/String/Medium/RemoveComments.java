class Solution {

	boolean hasBlockCommentStarted = false;

    public List<String> removeComments(String[] source) {
    	List<String> sourceCode = new ArrayList<>();
        boolean appendOnSameLine = false;
    	for (String sourceLine : source) {
    		String sCode = processLine(sourceLine);
            if (hasBlockCommentStarted && sCode.length() > 0) {
                appendOnSameLine = true;
            }
            if (appendOnSameLine && !hasBlockCommentStarted) {
                String lastLine = sourceCode.get(sourceCode.size() - 1);
                sourceCode.remove(sourceCode.size() - 1);
                sourceCode.add(lastLine + sCode);
                appendOnSameLine = false;
            } else if (sCode.length() > 0) {
                sourceCode.add(sCode);                    
    		} 
    	}
    	return sourceCode;
     }

    public String processLine(String lineString) {
    	StringBuilder sBuilder = new StringBuilder();
    	char[] line = lineString.toCharArray();
    	int index = 0;
        
    	while (index < line.length) {
            //System.out.print(line[index] + " ");
    		if (hasBlockCommentStarted) {
    			if (line[index] == '*') {    				
    				if (index + 1 < line.length && line[index + 1] == '/') {
    					hasBlockCommentStarted = false;
                        index++;
    				}
    			}
                index++;
    			continue;
    		}
    		if (line[index] == '/') {    			
    			if (index + 1 < line.length && line[index + 1] == '/' && !hasBlockCommentStarted) {                                        
    				break;
    			}  else if (index + 1 < line.length && line[index + 1] == '*') {
                    index += 2;
    				hasBlockCommentStarted = true;                    
    				continue;
    			}	
    		}            
    		sBuilder.append(line[index]);
            index++;
    	}
    	return sBuilder.toString();
    }
}
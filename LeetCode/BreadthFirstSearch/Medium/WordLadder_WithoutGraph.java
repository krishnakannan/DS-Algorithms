import java.util.*;
import java.lang.*;
import java.io.*;

//String Manipulation Solution

class WordLadderSM {

	public static void main(String args[]) {
		WordLadder wl = new WordLadder();
		Scanner in = new Scanner(System.in);
		String dictWord = "";
		int lineNumber = 1;		
		String beginWord = "";
		String endWord = "";
		List<String> wordList = new ArrayList<>();        
		try {
			InputStream is = new FileInputStream("nanny.txt");
			BufferedReader buf = new BufferedReader(new InputStreamReader(is));		        
			String line = buf.readLine();			
			while(line != null){
			   if (lineNumber == 1) {
					beginWord = line;

			   } else if (lineNumber == 2) {
			   		endWord = line;
			   } else {
			   		String[] words = line.split(" ");
			   		int i = 0;
					do {
						dictWord = words[i];
						wordList.add(dictWord);
						i++;
					} while(!dictWord.equals("0") && i < words.length);
			   }
			   lineNumber++;
			   line = buf.readLine();
			}
		} catch(IOException e) {

		}				
		wordList.remove("0");
		long startTime = System.nanoTime();						
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
		System.out.println((System.nanoTime() - startTime)/(1000 * 1000) + " Milliseconds");
	}   
	
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {        
                
        Set<String> wordSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> bfsQ = new LinkedList<>();                
        bfsQ.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();

            for (int i = 0; i < size; i++) {
                String str = bfsQ.poll();
                char[] sArray = str.toCharArray();
                for (int j = 0; j < sArray.length; j++) {
                    char temp = sArray[j];
                    for (char x = 'a'; x <= 'z'; x++) {
                        sArray[j] = x;
                        String newString = new String(sArray);
                        if (!str.equals(newString)) {
                            if (wordSet.contains(newString) && !visited.contains(newString)) {
                                bfsQ.add(newString);
                                visited.add(newString);
                                if (newString.equals(endWord)) {
                                    return level + 1; 
                                }
                            }
                        }                        
                    }
                    sArray[j] = temp;
                }
            }
            level++;        	
        }
        return 0;
    }    
}

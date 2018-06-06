import java.util.*;
import java.lang.*;
import java.io.*;

class StrongPasswordChecker {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		String s = in.nextInt();
		StrongPasswordChecker spc = new StrongPasswordChecker();
		System.out.println(spc.strongPasswordChecker(s));

	}


	int digitCount = 0;
	int lcCount = 0;
	int ucCount = 0;
	int others = 0;	
    int replacement[] = new int[3];    
    int totalReplacement = 0;

    public int strongPasswordChecker(String s) {
        char[] password = s.toCharArray();
        analyze(password);
        int mandatoryAdd = digitCount == 0 ? 1 : 0;
        mandatoryAdd += lcCount == 0 ? 1 : 0;
        mandatoryAdd += ucCount == 0 ? 1 : 0;
        analyzeSimilar(password);        
        if (password.length < 6) {
        	return mandatoryAdd > (6 - password.length) ? mandatoryAdd : (6 - password.length);
        } 
        
        if (password.length >= 6 && password.length <= 20) {
            return totalReplacement < mandatoryAdd ? mandatoryAdd : totalReplacement;
        }
        
        int mandatoryDelete = password.length - 20;
        
        
        totalReplacement -= Math.min(mandatoryDelete, replacement[0]);
        totalReplacement -= Math.min(Math.max(mandatoryDelete - replacement[0], 0), replacement[1] * 2) / 2;
        totalReplacement -= Math.max(mandatoryDelete - replacement[0] - 2 * replacement[1], 0) / 3;
        
        
        return mandatoryDelete + Math.max(totalReplacement, mandatoryAdd);
        
    }
    

    public void analyze(char[] password) {        
    	for (int i = 0; i < password.length; i++) {                		
            if (password[i] >= '0' && password[i] <= '9') {                
                digitCount += 1;
            } else if (password[i] >= 'A' && password[i] <= 'Z') {                
                ucCount += 1;
            } else if (password[i] >= 'a' && password[i] <= 'z') {                
                lcCount += 1;
            } else {                
                others += 1;
            }    	            
    	}    	
    }
    
    public void analyzeSimilar(char[] password) {
        int index = 0;
        while (index < password.length) {
            int endIndex = index + 1;
            while (endIndex < password.length && password[index] == password[endIndex]) {
                endIndex += 1;
            }
            if (endIndex - index >= 3) {                
                int len = endIndex - index;                
                totalReplacement += len / 3;
                if (len % 3 == 0) {
                    replacement[0] += 1;
                }
                if (len % 3 == 1) {
                    replacement[1] += 1;
                }
                if (len % 3 == 2) {
                    replacement[2] += 1;
                }
                index = endIndex;
            } else {
                index += 1;
            }
            
        }
    }
}
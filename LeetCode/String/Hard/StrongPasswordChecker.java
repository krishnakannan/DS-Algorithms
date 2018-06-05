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
	int similar3Count = 0;

    public int strongPasswordChecker(String s) {
        char[] password = s.toCharArray();
        analyze(password);
        int changes = 0;
        int mandatoryAdd = 0;
        int mandatoryDelete = 0;
        if (lcCount == 0) {
        	mandatoryAdd += 1;
        }
        if (ucCount == 0) {
        	mandatoryAdd += 1;
        }
        if (digitCount == 0) {
        	mandatoryAdd += 1;
        }

        if (password.length < 6) {
        	return mandatoryAdd > (6 - password.length) ? mandatoryAdd : (6 - password.length);
        }        
  
        //Instead of adding we can replace the similar places with mandatory adds.
        while (mandatoryAdd > 0 && similar3Count > 0) {
        	similar3Count -= 1;
        	mandatoryAdd -= 1;
        	changes += 1;
        }
        

        if (password.length > 20) {
        	mandatoryDelete = password.length - 20;
        }

        while (mandatoryDelete > 0 && similar3Count > 0) {
        	similar3Count -= 1;
        	mandatoryDelete -= 1;
        	changes += 1;
        }

		changes += mandatoryAdd;        
        changes += mandatoryDelete;
        changes += similar3Count;

        return changes;
    }

    public void analyze(char[] password) {
    	for (int i = 0; i < i < password.length; i++) {
    		if (i < password.length - 3) {
    			boolean same = true;
    			for (int j = i; j < 3; j++) {
    				if (password[i] != password[j]) {
    					same = false;
    					break;
    				}
    			}
    			if (same) {
    				similar3Count += 1;
    				//Mark this
    				password[i + 2] = "\t";
    			}
    		}     		
    	}
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
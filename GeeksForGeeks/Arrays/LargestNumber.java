import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/largest-number-formed-from-an-array/0

class LargestNumberArray {
	public static void main (String[] args) {
		LargestNumberArray ln = new LargestNumberArray();
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();		
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			System.out.println(ln.maxNumber(arr));
 		}
	}

	public String maxNumber(int[] arr) {
		if(arr == null || arr.length == 0)
		    return "";
				
		String[] str = new String[arr.length];
		for(int i = 0; i < arr.length; i++) {			
		    str[i] = String.valueOf(arr[i]);
		}

		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
			    String s1 = str1 + str2;
				String s2 = str2 + str1;
				return s2.compareTo(s1);
			}
		};

		Arrays.sort(str, comp);                
		if (s_num[0].charAt(0) == '0') {			
        	return "0";
		}
            
		StringBuilder sb = new StringBuilder();
		for(String s : s_num) {
			sb.append(s);				
		}
		return sb.toString();
	}
}
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int slen = s.length();
     	int tlen = t.length();
     	if (slen != tlen) {
     		return false;
     	}   
     	char[] map = new char[256];
     	char[] revMap = new char[256];

     	for(int i = 0; i < slen; i++) {
     		map[s.charAt(i)] = t.charAt(i);
     		revMap[t.charAt(i)] = s.charAt(i);
     	}
     	StringBuilder sb = new StringBuilder();
     	StringBuilder revSb = new StringBuilder();
     	for (int i = 0; i < slen; i++) {	
     		sb.append(map[s.charAt(i)]);
     		revSb.append(revMap[t.charAt(i)]);
     	}     	
     	if (sb.toString().equals(t) && revSb.toString().equals(s)) {
     		return true;
     	} else {
     		return false;
     	}   
    }
}
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int s1len = s1.length();
		int s2len = s2.length();
        if (s1len > s2len) {
            return false;
        }
    	int[] s1map = new int[256];
    	int[] s2map = new int[256];

    	for (int i = 0; i < s1len; i++) {
    		s1map[s1.charAt(i)]++;
    	}
        // System.out.println("S1");
        // for (int z = 0; z < s1map.length; z++) {
        //     if (s1map[z] > 0) {
        //         System.out.print((char)z +" => "+ s1map[z]+ "  ");
        //     }
        // }
        // System.out.println();        
        // System.out.println("S2");
    	for (int i = 0; i < s2len; i++) {
    		if (s1map[s2.charAt(i)] > 0) {
    			Arrays.fill(s2map, 0);
    			boolean isPer = false;
                int count = 0;
    			for (int x = i; x < i + s1len && x < s2len; x++) {    	
    				s2map[s2.charAt(x)]++;
    			}
                // for (int z = 0; z < s2map.length; z++) {
                //     if (s2map[z] > 0) {
                //         System.out.print((char)z +" => "+ s2map[z] + "  ");
                //     }
                // }
                // System.out.println();
    			for (int x = 0; x < s2map.length; x++) {
    				
    				if (s2map[x] > 0) {                        
    					if (s2map[x] == s1map[x]) {
                            count+=s2map[x];
    						isPer = true;	
    					} else {
							isPer = false;    					
							break;
    					}    					
    				}
    			}
    			if (isPer && count == s1len) {
    				return isPer;
    			}
    		}
    	}

    	return false;     
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        List<String> numList = new ArrayList<>();
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            numList.add(Integer.toString(nums[i]));            
        }
        
        Collections.sort(numList, new Comparator<String>(){
            public int compare(String a, String b) {
                char[] aArr = a.toCharArray();
                char[] bArr = b.toCharArray();
                int i = 0;
                int j = 0;
                while (i < aArr.length && j < bArr.length) {
                    if (aArr[i] < bArr[j]) {
                        return 1;
                    } else if (aArr[i] > bArr[j]) {
                        return -1; 
                    } else {
                        i++;
                        j++;
                    }
                }
                
                if (i == aArr.length && j <= bArr.length - 1) {
                    if (bArr[j] == aArr[i - 1]) {
                        return aArr.length - bArr.length;
                    } else if (bArr[j] < aArr[i - 1] || bArr[j] < aArr[0]) {
                        return -1;
                    } else {
                        return 1;    
                    }                    
                } else if (i <= aArr.length - 1 && j == bArr.length) {
                    if (aArr[i] == bArr[j - 1]) {
                        return bArr.length - aArr.length;
                    } if (aArr[i] < bArr[j - 1] || aArr[i] < bArr[0]) {
                        return 1;
                    } else {
                        return -1;    
                    }                    
                } else {
                    return 0;
                }
                
            }
        });
        
        if (!numList.isEmpty() && numList.get(0).equals("0")) {
            return "0";
        }
        
        for (String s : numList) {
            sBuilder.append(s);
        }
        return sBuilder.toString();
        
    }
}
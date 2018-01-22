class Solution {
    public List<Integer> grayCode(int n) {        
        int x = 2;
        List<Integer> grayCodeList = new ArrayList<>();
        if (n == 0) {
            grayCodeList.add(0);
            return grayCodeList;
        } else if (n == 1) {
            grayCodeList.add(0);
            grayCodeList.add(1);
            return grayCodeList;
        } else {
            grayCodeList.add(0);
            grayCodeList.add(1);
        }
        for(int i=0; i<n-1; i++) {
            for(int j=grayCodeList.size()-1; j>=0; j--) 
                grayCodeList.add(grayCodeList.get(j) + x);
            x *=2;       
        }
        return grayCodeList;
    }
}
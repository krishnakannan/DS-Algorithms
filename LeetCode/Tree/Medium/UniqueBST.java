public class Solution {
    public int numTrees(int n) {
        
        long cat = 1l;
        long d = 1l;
        
        List<Integer> vals = new ArrayList<>();
        for (int i = 2 * n; i >= n + 2; i--) {
            vals.add(i);
        }
        boolean flag = false;
        for (int i = n; i > 1; i--) {
            flag = false;
            for (int j = 0; j < vals.size(); j++) {
                int x = vals.get(j);
                if (x % i == 0) {
                    x /= i;
                    vals.set(j, x);
                    flag = true;
                    break;
                }
            }
            if (flag == false) {
                d =  d * i;
            }
        }
        for (int x : vals) {
            cat *= x;
        }
        
        long retVal = cat / d;
        return (int) retVal;
    }
}
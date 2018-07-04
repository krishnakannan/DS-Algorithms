class Solution {
    public boolean lemonadeChange(int[] bills) {
        if (bills.length == 0) {
            return true;
        } else if (bills[0] > 5) {
            return false;
        }
        int fiveDollars = 0;
        int tenDollars = 0;
        int twentyDollars = 0;
        
        for (int i = 0; i < bills.length; i++) {
            int change = bills[i] - 5;
            while (change > 0) {
                if (change >= 10 && tenDollars > 0) {
                    tenDollars -= 1;
                    change -= 10;
                } else if (change >= 5 && fiveDollars > 0) {
                    fiveDollars -= 1;
                    change -= 5;
                } else {
                    break;
                }
            }
            
            if (change > 0) {
                return false;
            }
            
            if (bills[i] == 5) {
                fiveDollars += 1;
            } else if (bills[i] == 10) {
                tenDollars += 1;
            } else {
                twentyDollars += 1;
            }
            //System.out.println("5$ " + fiveDollars + " 10$ " + tenDollars + " 20$ " + twentyDollars);
        }
        
        return true;
    }
}
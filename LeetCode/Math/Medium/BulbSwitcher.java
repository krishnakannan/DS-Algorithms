import java.util.*;
import java.lang.*;
import java.io.*;

class BulbSwitcher {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BulbSwitcher bs = new BulbSwitcher();
        System.out.println(bs.bulbSwitch(n));
    }

    /*
        Math Solution - Referred
        
        A Bulb is switched on only if it has odd number of factors including 1 and n.

        so count number of divisors 

            example 12, 13 and 16

            12 => 1,12  2,6  3,4 They have even number of factors so they get toggled even number of time and it is always switched off.

            Prime Numbers like 13 => 1,13 They also have only even number of factors.

            16 => 1,16 2,8 4 They have odd number of factors So they get toggled odd number of time. They always remain switched on.

            Therefore Only square number are switched on. We have to count number of Square numbers. or simply we can find Sqrt(num).

    */

    public int bulbSwitch(int n) {
        return sqrt(n);
    }

    public int sqrt(int n) {
        if (n == 0 || n == 1) {            
            return n;
        }

        int i = 1;
        int result = 1;
        while (result < n) {
            i++;
            result = i * i;                      
        }
        return result == n ? i : i - 1;
    }
}
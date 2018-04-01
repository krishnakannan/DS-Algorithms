public class Solution {
    public boolean checkPerfectNumber(int num) {
        int pNum = 1;
        int sqrt = (int)Math.ceil(Math.sqrt(num));
        for (int i = 2; i < sqrt; i++) {
        	pNum = num % i == 0 ? num/i == i ? pNum + i : pNum + i + num/i : pNum;
        }
        return pNum == num && num != 1 ? true : false;
    }
}
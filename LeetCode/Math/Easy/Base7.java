public class Solution {
    public String convertToBase7(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) {
            return "0";
        }
        int abs = Math.abs(num);
        while (abs != 0) {
            sb.append(abs % 7);
            abs /= 7;
        }
        sb.append(num < 0 ? "-" : "");
        return sb.reverse().toString();
    }
}
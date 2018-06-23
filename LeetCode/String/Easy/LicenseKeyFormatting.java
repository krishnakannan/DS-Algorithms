class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder builder = new StringBuilder();
        char[] str = S.toCharArray();
        int kV = 0;
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] == '-') {
             continue;
            }
            kV += 1;
            builder.append(Character.toUpperCase(str[i]));
            if (kV % K == 0) {
                kV = 0;
                builder.append("-");
            }
        }
        if (builder.length() == 0) {
            return "";
        }
        String formatted = builder.reverse().toString();
        return formatted.charAt(0) == '-' ? formatted.substring(1, formatted.length()) : formatted;
    }
}
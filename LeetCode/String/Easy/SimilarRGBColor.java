class Solution {
    public String similarRGB(String color) {
        int R = Integer.parseInt(color.substring(1, 3), 16);
        int G = Integer.parseInt(color.substring(3, 5), 16);
        int B = Integer.parseInt(color.substring(5, 7), 16);
        int similarity = Integer.MAX_VALUE;
        String similarColor = "";
        for (int i = 0; i <= 255; i += 17) {
            for (int j = 0; j <= 255; j += 17) {
                for (int k = 0; k <= 255; k += 17) {
                    int localSimilarity = getAbs(getSimilarity(R, G, B, i, j, k));
                    if (similarity > localSimilarity) {
                        similarColor = i == 0 ? "00" : Integer.toHexString(i);
                        similarColor += j == 0 ? "00" : Integer.toHexString(j);
                        similarColor += k == 0 ? "00" : Integer.toHexString(k);
                        similarity = localSimilarity;
                    }
                }
            }
        }
        return "#" + similarColor;
    }    
    
    public int getSimilarity(int R, int G, int B, int NR, int NG, int NB) {
        return -((R - NR) * (R - NR)) - ((G - NG) * (G - NG)) - ((B - NB) * (B - NB));
    }
    
    public int getAbs(int num) {
        return num < 0 ? -num : num;
    }
}
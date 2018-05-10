/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int index = 4;
    int readFromRead4 = 0;
    char[] cache = new char[4];

    public int read(char[] buf, int n) {
        int cIndex = 0;
        while (cIndex < n) {
            if (index == 4) {
                readFromRead4 = read4(cache);                
                index = 0;
            }
            if (index < readFromRead4) {
                buf[cIndex] = cache[index];
                cIndex++;
                index++;
            } else {
                break;
            }
        }
        return cIndex;
    }
}
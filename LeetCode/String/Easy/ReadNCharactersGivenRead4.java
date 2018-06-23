/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
  
    public int read(char[] buf, int n) {
        char[] cache = new char[4];
        boolean eof = false;
        int totalBytesRead = 0;
        
        while (totalBytesRead < n && !eof) {
            int bytesRead = read4(cache);
            if (bytesRead !=4) {
                eof = true;
            }
            int length = Math.min(n - totalBytesRead, bytesRead);
            for (int i = 0; i < length; i++) {
                buf[totalBytesRead + i] = cache[i];
            }
            totalBytesRead += length;
        }
        return totalBytesRead;
    }
}
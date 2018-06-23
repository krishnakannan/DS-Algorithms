class Solution {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }
        int readIndex = 1;
        int writeIndex = 0;
        int prevIndex = 0;
        while (readIndex < chars.length) {
            if (chars[readIndex] == chars[readIndex - 1]) {
                readIndex += 1;
            } else {                
                if (readIndex - prevIndex > 1) {
                    int length = readIndex - prevIndex;
                    chars[writeIndex] = chars[readIndex - 1];
                    writeIndex += 1;
                    boolean addZero = length % 10 == 0;
                    while (length > 0) {                        
                        int digit = length / (int)Math.pow(10, getDigits(length) - 1);
                        chars[writeIndex] = (char)(digit + '0');
                        writeIndex += 1;
                        length = length % (int)Math.pow(10, getDigits(length) - 1);                        
                    }
                    if (addZero) {
                        chars[writeIndex] = '0';
                        writeIndex += 1;
                    }
                    
                    prevIndex = readIndex;
                    readIndex += 1;
                } else {
                    chars[writeIndex] = chars[readIndex - 1];
                    writeIndex += 1;
                    prevIndex = readIndex;
                    readIndex += 1;
                }
            }
        }        
        if (readIndex - prevIndex > 1) {
            int length = readIndex - prevIndex;
            chars[writeIndex] = chars[readIndex - 1];
            writeIndex += 1;
            boolean addZero = length % 10 == 0;
            
            while (length > 0) {                        
                int digit = length / (int)Math.pow(10, getDigits(length) - 1);
                chars[writeIndex] = (char)(digit + '0');
                writeIndex += 1;
                length = length % (int)Math.pow(10, getDigits(length) - 1);                        
            }
            if (addZero) {
                chars[writeIndex] = '0';
                writeIndex += 1;
            }
            //
            prevIndex = readIndex;
            readIndex += 1;
            return writeIndex;
        } else {
            chars[writeIndex] = chars[readIndex - 1];
            writeIndex += 1;
            prevIndex = readIndex;
            readIndex += 1;
        }
        
        return writeIndex;
    }
    
    public int getDigits(int num) {
        return num == 0 ? 1 : (int)(Math.log10(num) + 1);
    }
}
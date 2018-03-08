class Solution {
    public boolean validUtf8(int[] data) {
    	int index = 0;
    	while (index < data.length) {
    		int dataSize = getByteInformation(data[index]);            
            //System.out.println("Size " + dataSize + " Current Index " + index);
    		if (dataSize == -1) {
    			return false;
    		}
            
    		if (index + dataSize > data.length) {                                
    			return false;
    		}
            
    		index++;

    		while (--dataSize > 0) {
    			if (!isValidByteInfo(data[index])) {
    				return false;
    			}
    			index++;
    		}
    	}
        return true;
    }

    public int getByteInformation(int data) {
    	int num = 1 << 7;
    	int count = 0;
    	if ((data & num) == 0) {
    		return 1;
    	} else {
    		int val = data & num;
    		int ones = 0;
    		while (val != 0) {
    			count++;
    			ones++;
    			data = data << 1;
    			val = data & num;
    		}
    		if (ones > 4) {
    			return -1;
    		}
    	}        
    	return count == 1 ? - 1: count;
    }

    public boolean isValidByteInfo(int data) {
    	int num = 1 << 7;        
        int shiftedData = data << 1;
        //System.out.println("Data " + data + " Num " + num + " Shifted Data " + shiftedData);
    	return (num & data) != 0 && (shiftedData & num) == 0;
    }
}
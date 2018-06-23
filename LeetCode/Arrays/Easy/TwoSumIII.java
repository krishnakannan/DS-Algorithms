class TwoSum {
        
    List<Integer> list;

    /** Initialize your data structure here. */
    public TwoSum() {
        list = new ArrayList<>();        
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Collections.sort(list);
        Integer[] array = list.toArray(new Integer[list.size()]);        
        
        if (array.length == 0) {
            return false;
        }
             
        int left = 0;
        int right = array.length - 1;        
        Integer val = null;
        while (left < right) {            
            val = array[left] + array[right];
            if (val < value) {
                val -= array[left];
                left += 1;
                val += array[left];
            } else if (val > value) {
                val -= array[right];
                right -= 1;
                val += array[right];
            } else {
                return true;
            }    

        }        
        return val != null && val.equals(value) && right > left;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
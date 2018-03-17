class Solution {
    public int reachNumber(int target) {
        int index = 0;
        int num = 0;
        if (target < 0) {
            while (num > target) {
                num = num - index;
                index++;
            }   
        } else {
            while (num < target) {
                num = num + index;
                index++;
            }    
        }
        
        
        
//         int tempIndex = index - 1;        
//         System.out.println("index " + tempIndex + " -> " + ((tempIndex * (tempIndex + 1)) / 2));        
//         if (((tempIndex * (tempIndex + 1)) / 2) == target) {
//             return tempIndex;
//         }
        if (target < 0) {
            if (target % 2 == 0) {
                while (num % 2 != 0) {                
                    num -= index;
                    index++;
                }    
            } else {
                while (num % 2 == 0) {                
                    num -= index;
                    index++;
                }
            }
        } else {
            if (target % 2 == 0) {
                while (num % 2 != 0) {                
                    num += index;
                    index++;
                }    
            } else {
                while (num % 2 == 0) {                
                    num += index;
                    index++;
                }
            }   
        }        
        
        return --index;
    }
}
class Solution {
    List<Integer> lexicalList;
    int index = 0;
    int num = 1;
    public List<Integer> lexicalOrder(int n) {
        lexicalList =  new ArrayList<>(n);
        fillList(n);
        ////System.out.println(lexicalList);
        return lexicalList;
    }
    
    public void fillList(int n) {        
        if (num > n) {
            return;
        }        
        while (index < n) {
            //System.out.println("Index " + index + " num " + num);
            lexicalList.add(index, num);
            index++;
            if (num * 10 <= n) {                
                num = num * 10;                
                fillList(n);                
                num = num / 10;
                num += 1;              
                while (num % 10 == 0) {                    
                    num /= 10;
                }               
            } else {                
                int x = (num + 1) / 10;
                if (num / 10 != x) {
                    return;
                }
                for (int i = 0; i < 9 && index < n && num + i + 1 <= n; i++) {                 
                    if ((num + i + 1) / 10 == x) {
                        lexicalList.add(index, num + i + 1);    
                        index++;
                    } else {
                        return;
                    }                    
                }
                return;
            }    
        }
        
    }
}
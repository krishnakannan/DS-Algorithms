class Solution {
    public void reverseWords(char[] str) {
 		
 		//reverse the entire string first.
    	reverse(str, 0, str.length - 1);


    	int left = 0;
    	int right = 0;
    	int nextWord = 0;
    	//tokenize and reverse each word
    	for (int i = 0; i < str.length; i++) {
    		if (str[i] != ' ') {
    			right++;
    		} else {
    			nextWord = right + 1;
    			right--;
    			reverse(str, left, right);
    			left = nextWord;
    			right = left;
    		}
    	}
        reverse(str, left, str.length - 1);
    }

    public void reverse(char[] str, int left, int right) {
    	while (left <= right) {
    		swap(str, left, right);
    		left++;
    		right--;
    	}
    }

    public void swap(char[] str, int p1, int p2) {
    	char temp = str[p1];
    	str[p1] = str[p2];
    	str[p2] = temp;
    }
}
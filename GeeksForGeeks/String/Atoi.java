/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*You are required to complete this method */

//https://practice.geeksforgeeks.org/problems/implement-atoi/1

class GfG
{
    public int atoi(String s) {
    	char[] array = s.toCharArray();
    	int value = 0;
    	boolean isNegative = false;
    	int i = 0;
    	if (array[0] == '-') {
    		isNegative = true;
    		i = 1;
    	}
    	for (; i < array.length; i++) {
    		value *= 10;
    		int currentInt = (int)array[i] - 48; //ASCII for 0 is 48
    		if (currentInt >= 0 && currentInt < 10) {
    			value += currentInt;
    		} else {
    			return -1;
    		}
    	}
    	return value;
	}
}

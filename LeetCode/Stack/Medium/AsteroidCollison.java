//https://leetcode.com/problems/asteroid-collision/description/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> aStack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
        	if (aStack.empty()) {
        		aStack.push(asteroids[i]);        	
        	} else if (asteroids[i] < 0 && aStack.peek() > 0)  {

        		if (-asteroids[i] == aStack.peek()) {
        			aStack.pop();
        			continue;
        		}
        		boolean hasAsteroidBlown = false;
        		//Possibility of Collision
        		//Asteroid must always be negative and stack val must always be positive
        		while (!aStack.empty()) {        			
        			if (aStack.peek() < 0) {
        				break;
        			} else if (aStack.peek() < -asteroids[i]) {
        				aStack.pop();
        			} else if (aStack.peek() == -asteroids[i]) {
        				aStack.pop();
        				hasAsteroidBlown = true;
        				break;
        			} else {
        				hasAsteroidBlown = true;
        				break;
        			}
        		}
        		if (!hasAsteroidBlown) {
        			aStack.push(asteroids[i]);
        		}
        	} else {
        		aStack.push(asteroids[i]);
        	}        	
        }
        int[] arr = new int[aStack.size()];
        for (int i = arr.length - 1; i >= 0; i--) {
        	arr[i] = aStack.pop();
        }
        return arr;
    }
}
class Solution {
	
	Queue<Long> pQueue = new PriorityQueue<Long>();

	public int nthSuperUglyNumber(int n, int[] primes) {
		if (n == 1) {
			return 1;
		}
		long currentLength = 1l;
		long currentNumber = 0l;
		pQueue.add(1l);		
		while (currentLength <= n) {            
			while (!pQueue.isEmpty() && currentNumber == pQueue.peek()) {
				currentNumber = pQueue.poll();
			}			
			currentNumber = pQueue.isEmpty() ? currentNumber : pQueue.poll();
			addElementsToQueue(currentNumber, primes);
			currentLength++;
		}
		return (int)currentNumber;
	}

	public void addElementsToQueue(long currentNumber, int[] primes) {
		for (int i = 0; i < primes.length; i++) {
            long mulValue = currentNumber * primes[i];
            if (mulValue < Integer.MAX_VALUE) {
                pQueue.add(mulValue);        
            }            
		}
	}
}
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer cacheValue = null;
    Iterator iterator;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        if (iterator.hasNext()) {
            this.cacheValue = (Integer)iterator.next();       
        } else {
            this.cacheValue = null;
        }
        
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cacheValue;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int temp = cacheValue;
        if (iterator.hasNext()) {
            this.cacheValue = (Integer)iterator.next();       
        } else {
            this.cacheValue = null;
        }
        return temp;
	}

	@Override
	public boolean hasNext() {
	    return cacheValue != null;
	}
}
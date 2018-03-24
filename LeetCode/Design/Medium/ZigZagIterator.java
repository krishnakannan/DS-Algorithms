public class ZigzagIterator {
    
    //Solution is 2 ms slower than best(6%ile). but it will work well for the followup qn. Using more than 2 list of integers.

    Queue<Iterator> queue;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        queue.add(v1.iterator());
        queue.add(v2.iterator());
    }

    public int next() {
        Integer val = (Integer)queue.peek().next();
        queue.add(queue.poll());
        return val;
    }

    public boolean hasNext() {
        if (queue.isEmpty()) {
            return false;
        } else {
            while (!queue.isEmpty() && !queue.peek().hasNext()) {
                queue.poll();
            }
            return !queue.isEmpty() && queue.peek().hasNext();
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
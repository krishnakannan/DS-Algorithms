public class Vector2D implements Iterator<Integer> {

    Iterator internalListIterator;
    Iterator externalListIterator;
    List<Integer> internalList;
    
    public Vector2D(List<List<Integer>> vec2d) {        
        externalListIterator = vec2d.iterator();        
    }

    @Override
    public Integer next() {        
        return (Integer)internalListIterator.next();
                
    }

    @Override
    public boolean hasNext() {
        
        if (internalListIterator != null && internalListIterator.hasNext()) {
            return true;    
        }
        
        while (externalListIterator != null && externalListIterator.hasNext()) {            
            
            if (internalListIterator == null || !internalListIterator.hasNext()) {
                internalList = (List<Integer>)externalListIterator.next();            
                internalListIterator = internalList.iterator();
            }
            
            if (!internalListIterator.hasNext()) {
                continue;
            } else {
                return true;
            }
        }
        
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
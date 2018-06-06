class RandomizedCollection {

    HashMap<Integer, LinkedHashSet<Integer>> mapOfIndex;
    List<Integer> elements;
    int x = 0;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        mapOfIndex = new HashMap<>();
        elements = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {                
        boolean needToInsert = false;
        if (!mapOfIndex.containsKey(val)) {
            mapOfIndex.put(val, new LinkedHashSet());
            needToInsert = true;
        }
        elements.add(val);
        int index = elements.size() - 1;
        mapOfIndex.get(val).add(index);
        return needToInsert;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {    
        Integer lastElement = elements.size() > 0 ? elements.get(elements.size() - 1) : Integer.MIN_VALUE;
        
        if (!mapOfIndex.containsKey(val)) {
            return false;
        } else if (elements.size() == 1) {
            mapOfIndex.remove(val);
            elements.clear();
            return true;
        } else if (lastElement == val) {
            mapOfIndex.get(lastElement).remove(elements.size() - 1);
            if (mapOfIndex.get(lastElement).size() == 0) {
                mapOfIndex.remove(lastElement);
            }
            elements.remove(elements.size() - 1);
            return true;
        }
        
        Iterator iterator = mapOfIndex.get(val).iterator();
        Integer indexToRemove = (Integer)iterator.next();
        mapOfIndex.get(val).remove(indexToRemove);        
        elements.set(indexToRemove, lastElement);        
        mapOfIndex.get(lastElement).remove(elements.size() - 1);
        mapOfIndex.get(lastElement).add(indexToRemove);        
        elements.remove(elements.size() - 1);
        
        if (mapOfIndex.get(val).size() == 0) {
            mapOfIndex.remove(val);
        }       
        
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {        
        int randIndex = randInt(0, elements.size());
        return elements.get(randIndex);   
    }

    public int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min)));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
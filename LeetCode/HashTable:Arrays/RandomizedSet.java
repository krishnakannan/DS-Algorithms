class RandomizedSet {

    Map<Integer, Integer> map;
    List<Integer> mapKeys;
    Set<Integer> set;
    
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        mapKeys = new ArrayList<>();
        set = new HashSet<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean insertVal = set.add(val);
        if (insertVal) {
            map.put(val, val);
            mapKeys.add(val);
        }
        
        return insertVal;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean removeVal = set.remove(val);
        if (removeVal) {
            map.remove(val);
            mapKeys.remove((Integer)val);    
        }        
        return removeVal;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int randIndex = randInt(0, set.size() - 1);        
        return (int)map.get(mapKeys.get(randIndex));
    }
    
    public int randInt(int min, int max) {
        return min + (int)(Math.random() * ((max - min) + 1));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
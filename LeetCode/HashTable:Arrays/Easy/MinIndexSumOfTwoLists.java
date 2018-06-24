class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> andys = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            andys.put(list1[i], i);
        }
        
        List<String> chosen = new ArrayList<>();
        int sumIndex = Integer.MAX_VALUE;        
        for (int i = 0; i < list2.length; i++) {
            if (andys.containsKey(list2[i])) {
                int sIndex = andys.get(list2[i]) + i;
                if (sIndex < sumIndex) {
                    chosen.clear();
                    chosen.add(list2[i]);
                    sumIndex = sIndex;
                } else if (sIndex == sumIndex) {
                    chosen.add(list2[i]);
                }
            }
        }
        return chosen.toArray(new String[chosen.size()]);
    }
}
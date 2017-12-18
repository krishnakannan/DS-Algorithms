class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
 		
 		Map<String, List<String>> stringMap = new HashMap<>();
 		List<List<String>> anagrams = new ArrayList<>();
 		for (String str : strs) {
 			String key = getMapAsKey(str);
 			if (stringMap.containsKey(key)) {
 				stringMap.get(key).add(str);
 			} else {
 				stringMap.put(key, new ArrayList<>());
 				stringMap.get(key).add(str);
 			}
 		}

 		for (Map.Entry<String, List<String>> entry : stringMap.entrySet()) {
 			anagrams.add(entry.getValue());
 		}

 		return anagrams;

    }

    public String getMapAsKey(String str) {    	
    	char[] strArr = str.toCharArray();
    	Arrays.sort(strArr);
    	return new String(strArr);
    }
}
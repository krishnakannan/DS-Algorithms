class Solution {
	public List<List<String>> groupStrings(String[] strings) {
		
		Map<String, List<String>> stringMap = new HashMap<>();
		List<List<String>> groupedList = new ArrayList<>();
		for (int i = 0; i < strings.length; i++) {
			String key = getKey(strings[i]);
			if (stringMap.containsKey(key)) {
				stringMap.get(key).add(strings[i]);
			} else {
				stringMap.put(key, new ArrayList<>());
				stringMap.get(key).add(strings[i]);
			}
		}

		for (Map.Entry<String, List<String>> entry : stringMap.entrySet()) {
			groupedList.add(entry.getValue());
		}
		return groupedList;
	}

	public String getKey(String string) {    	
		StringBuilder key = new StringBuilder();
		key.append(Integer.toString(string.length()));
		if (string.length() <= 1)  {
			return key.toString();
		}

		int i = 0;
		int j = i + 1;
		char[] strArr = string.toCharArray();

		while (j < strArr.length) {
			int diff = ((strArr[j] - 'a') - (strArr[i] - 'a'));
			diff = modulo(diff, 26);
			//System.out.println(strArr[j] + " - " + strArr[i] + " = " + diff);
			key.append(Integer.toString(diff));
			i++;
			j++;
		}
		
		//System.out.println("String - " + string + " key " + key);

		return key.toString();
	}
	public int modulo(int a, int b) {
		int ret = a % b;
		if (ret < 0)
			ret += b;
		return ret;
	}
}
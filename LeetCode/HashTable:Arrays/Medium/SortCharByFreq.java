class Solution {

	class CharFrequency {
		char ch;
		int freq;
		public CharFrequency(char ch, int freq) {
			this.ch = ch;
			this.freq = freq;
		}
	}

    public String frequencySort(String s) {
 		char[] sArray = s.toCharArray();
		Map<Character, CharFrequency> map = new HashMap<>();
		Queue<CharFrequency> pQueue = new PriorityQueue<CharFrequency>(new Comparator<CharFrequency>(){
			public int compare(CharFrequency a, CharFrequency b) {
				return b.freq - a.freq;
			}
		});

		for (int i = 0; i < sArray.length; i++) {
			if (map.containsKey(sArray[i])) {
				map.get(sArray[i]).freq += 1;
			} else {
				CharFrequency cFreq = new CharFrequency(sArray[i], 1);				
				map.put(sArray[i], cFreq);
			}
		}

		for (Map.Entry<Character, CharFrequency> entry : map.entrySet()) {
			pQueue.add(entry.getValue());
		}

		StringBuilder sBuilder = new StringBuilder();
		while (!pQueue.isEmpty()) {
			CharFrequency polled = pQueue.poll();
			for (int i = 0; i < polled.freq; i++) {
				sBuilder.append(polled.ch);
			}
		}
		return sBuilder.toString();
    }
}
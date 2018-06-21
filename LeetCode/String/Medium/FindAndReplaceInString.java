class FindAndReplaceInString {

	class FindAndReplace {
		int index;
		String find;
		String replaceWith;
		public FindAndReplace(int index, String find, String replaceWith) {
			this.index = index;
			this.find = find;
			this.replaceWith = replaceWith;
		}
	}
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
    	FindAndReplace[] frArray = new FindAndReplace[indexes.length];
    	for (int i = 0; i < indexes.length; i++) {
    		frArray[i] = new FindAndReplace(indexes[i], sources[i], targets[i]);
    	}

    	char[] original = S.toCharArray();

    	Arrays.sort(frArray, new Comparator<FindAndReplace>(){
    		public int compare(FindAndReplace a, FindAndReplace b) {
    			return b.index - a.index;
    		}
    	});
    	StringBuilder builder = new StringBuilder(S);
    	for (FindAndReplace fr : frArray) {
    		if (canReplace(original, fr.find, fr.index)) {
    			builder.delete(fr.index, fr.index + fr.find.length());
    			builder.insert(fr.index, fr.replaceWith);
    		}
    	}
    	return builder.toString();
    }

    public boolean canReplace(char[] original, String find, int index) {
    	int len = 0;
    	for (int i = index, j = 0; i < original.length && j < find.length(); i++, len++, j++) {
    		if (original[i] != find.charAt(j)) {
    			return false;
    		}
    	}
    	return len == find.length();
    }
}
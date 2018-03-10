class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
 		Map<String, List<String>> map = new HashMap<>();
 		List<List<String>> duplicates = new ArrayList<>();
 		for (String path : paths) {
 			String[] pathContent = path.split(" ");
 			String parentPath = pathContent[0];
 			for (int i = 1; i < pathContent.length; i++) {
 				String fileName = getFileName(pathContent[i]);
 				String content = getFileContent(pathContent[i]);
 				if (!map.containsKey(content)) {
 					map.put(content, new ArrayList<>()); 					
 				}
 				map.get(content).add(parentPath + "/" + fileName);
 			}
 		}

 		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
 			if (entry.getValue().size() > 1) {
 				duplicates.add(entry.getValue());
 			}
 		}

 		return duplicates;
    }

    public String getFileName(String str) {
    	StringBuilder sBuilder = new StringBuilder();
    	int sLength = str.length();
    	for (int i = 0; i < sLength; i++) {
    		if (str.charAt(i) == '(') {
    			break;
    		}
    		sBuilder.append(str.charAt(i));
    	}
    	return sBuilder.toString();
    }

    public String getFileContent(String str) {
    	StringBuilder sBuilder = new StringBuilder();
    	int sLength = str.length();
    	for (int i = sLength - 1; i >= 0; i--) {
    		if (str.charAt(i) == '(') {
    			break;
    		}
    		sBuilder.append(str.charAt(i));
    	}
    	return sBuilder.reverse().toString();	
    }
}
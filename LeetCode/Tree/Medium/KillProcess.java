class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
 		Map<Integer, List<Integer>> processMap = new HashMap<>();
 		int ppidSize = ppid.size();
 		for (int i = 0; i < ppidSize; i++) {
 			int currentPPID = ppid.get(i);
 			if (processMap.containsKey(currentPPID)) {
 				processMap.get(currentPPID).add(pid.get(i));
 			} else {
 				processMap.put(currentPPID, new ArrayList<>());
 				processMap.get(currentPPID).add(pid.get(i));
 			}
 		}

 		Queue<Integer> killQueue = new LinkedList<>();
 		List<Integer> killList = new ArrayList<>();
 		killQueue.add(kill);

 		while (!killQueue.isEmpty()) {
 			int currentKill = killQueue.poll();
 			killList.add(currentKill);
 			if (processMap.containsKey(currentKill)) {
 				killQueue.addAll(processMap.get(currentKill));
 			}
 		}

 		return killList;
    }
}
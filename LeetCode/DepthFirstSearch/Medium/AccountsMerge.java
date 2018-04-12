class Solution {
    
    Set<String> processed = new HashSet<>();
    Map<String, Set<String>> aList = new HashMap<>();
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> userEmailMap = new HashMap<>();        
        
        
        for (List<String> account : accounts) {
            String userName = account.get(0);
            int size = account.size();
            for (int i = 1; i < size; i++) {                
                userEmailMap.put(account.get(i), userName);
                if (!aList.containsKey(account.get(i))) {
                    aList.put(account.get(i), new HashSet<>());
                }
                if (i == 1) {
                    continue;
                }                
                aList.get(account.get(i - 1)).add(account.get(i));
                aList.get(account.get(i)).add(account.get(i - 1));                
            } 
        }     
        
        
        List<List<String>> mergedAccounts = new ArrayList<>();
        
        
        for (String email : userEmailMap.keySet()) {
            if (!processed.contains(email)) {
                mergedAccounts.add(new ArrayList<>());
                mergedAccounts.get(mergedAccounts.size() - 1).add(userEmailMap.get(email))
;                List<String> associatedEmails = dfs(email, new ArrayList<>());
                Collections.sort(associatedEmails);                    
                mergedAccounts.get(mergedAccounts.size() - 1).addAll(associatedEmails);
            }
        }
        return mergedAccounts;
    }   
    
    public List<String> dfs (String currentEmail, List<String> mergedSoFar) {        
        processed.add(currentEmail);
        mergedSoFar.add(currentEmail);
        Set<String> otherLinkedEmails = aList.get(currentEmail);
        for (String otherLinkedEmail : otherLinkedEmails) {
            if (!processed.contains(otherLinkedEmail)) {
                dfs(otherLinkedEmail, mergedSoFar);
            }
        }        
        return mergedSoFar;
    }
}
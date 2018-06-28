class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] domainCountArray = cpdomain.split(" ");
            int count = Integer.parseInt(domainCountArray[0]);
            String domain = domainCountArray[1];
            map.put(domain, map.getOrDefault(domain, 0) + count);
            for (int i = 1; i < domain.length(); i++) {
                
                if (domain.charAt(i) == '.') {                                        
                    String sub = domain.substring(i + 1);
                    map.put(sub, map.getOrDefault(sub, 0) + count);
                }
            }
        }
        List<String> subDomainVisits = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            subDomainVisits.add(entry.getValue() + " " + entry.getKey());
        }
        return subDomainVisits;
    }
}
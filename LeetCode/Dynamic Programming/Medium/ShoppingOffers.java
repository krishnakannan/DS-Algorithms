class Solution {
    int costWithoutOffer;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        costWithoutOffer = getCost(needs, price);
        int cost = shop(price, special, needs, new ArrayList<>(needs), 0);        
    	return cost;
    }
    
    
    Map<List<Integer>, Integer> dp = new HashMap<>(); 

    public int shop(List<Integer> price, List<List<Integer>> offers, List<Integer> originalNeeds, List<Integer> currentNeeds, int currentCost) {
        
    	if (dp.containsKey(currentNeeds)) {
    		return dp.get(currentNeeds);
    	}    	
    	List<Integer> needs = new ArrayList<>(currentNeeds);
        int cost = costWithoutOffer;
    	for (List<Integer> offer : offers) {        
    		int offerCost = applyOffer(needs, offer);
    		if (isNeedsValid(needs)) {                
                int tCost = shop(price, offers, originalNeeds, needs, currentCost + offerCost);                                
                cost = cost > tCost ? tCost : cost;
    		}
            revokeOffer(needs, offer);	    
    	}
                
    	int remainingCost = getCost(needs, price);
        
    	int finalCost = 0;
        if (cost + currentCost <= currentCost + remainingCost) {
            finalCost = cost;
        } else {
            finalCost = currentCost + remainingCost;
        }       
    	dp.put(needs, finalCost);

    	return dp.get(needs);
    }

    public int getCost(List<Integer> needs, List<Integer> price) {
    	int cost = 0;
    	int nLength = needs.size();
    	for (int i = 0; i < nLength; i++) {
    		cost += needs.get(i) * price.get(i);
    	}
    	return cost;
    }

    public int applyOffer(List<Integer> needs, List<Integer> offer) {
    	int nLength = needs.size();        
    	for (int i = 0; i < nLength; i++) {
    		needs.set(i, needs.get(i) - offer.get(i));
    	}        
    	return offer.get(offer.size() - 1);
    }

    public int revokeOffer(List<Integer> needs, List<Integer> offer) {
    	int nLength = needs.size();
    	for (int i = 0; i < nLength; i++) {
    		needs.set(i, needs.get(i) + offer.get(i));
    	}
    	return offer.get(offer.size() - 1);
    }

    public boolean isNeedsValid(List<Integer> needs) {
    	for (Integer need : needs) {
    		if (need < 0) {
    			return false;
    		}
    	}
    	return true;
    }
}
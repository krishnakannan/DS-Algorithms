import java.util.*;
import java.lang.*;
import java.io.*;

class OptimalAccountBalancing {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();		
		int[][] transactions = new int[m][3];
		for (int i = 0; i < transactions.length; i++) {
			for (int j = 0; j < transactions[0].length; j++) {
				transactions[i][j] = in.nextInt();
			}
		}
		OptimalAccountBalancing oab = new OptimalAccountBalancing();
		System.out.println(oab.minTransfers(transactions));
	}


	Map<Integer, Integer> balances;	
	int minimumTransactionCount = Integer.MAX_VALUE;
	int optimizedTransactionCount = 0;

    public int minTransfers(int[][] transactions) {
        balances = new HashMap<>();        
        List<Integer> balancesList = computeBalances(transactions);        
        Integer[] balancesArray = balancesList.toArray(new Integer[balancesList.size()]);
        settle(balancesArray, 0);
        minimumTransactionCount = minimumTransactionCount == Integer.MAX_VALUE ? 0 : minimumTransactionCount;
        return minimumTransactionCount + optimizedTransactionCount;
    }

    /*
		Exhaustive n! solution - NPC (Correct Implementation)
    */

    public void settle(Integer[] arr, int transactionCount) {
    	//System.out.println(Arrays.toString(arr));
    	if (arr.length < 2) {
            return;
        }
    	if (arr.length == 2) {
    		if (arr[0] == arr[1] && arr[0] == 0) {
    			minimumTransactionCount = minimumTransactionCount > transactionCount ? transactionCount : minimumTransactionCount; 
    		} else if (arr[0] == -arr[1]) {
    			transactionCount += 1;
    			minimumTransactionCount = minimumTransactionCount > transactionCount ? transactionCount : minimumTransactionCount; 
    		}
    		return;
    	}
    	int first = arr[0];
    	for (int i = 1; i < arr.length; i++) {
    		arr[i] += first;    		
    		settle(copyArray(arr, 0), transactionCount + 1);
    		arr[i] -= first;
    	}
    }

    public Integer[] copyArray(Integer[] array, int exclude) {
    	List<Integer> copiedList = new ArrayList<>();    	
    	for (int i = 0; i < array.length; i++) {
    		if (i == exclude) {
    			continue;
    		}
    		if (array[i] == 0) {
    			continue;
    		}
    		copiedList.add(array[i]);    		
    	}    	
    	return copiedList.toArray(new Integer[copiedList.size()]);
    }	

    /*
		Greedy Implementation will not work.
    */
    // public int settle() {
    // 	Queue<Integer> surplus = new PriorityQueue<Integer>(new Comparator<Integer>(){
    // 		public int compare(Integer a, Integer b) {
    // 			return b - a;
    // 		}
    // 	});

    // 	Queue<Integer> deficit = new PriorityQueue<>();

    // 	for (Map.Entry<Integer, Integer> balance : balances.entrySet()) {
    // 		if (balance.getValue() < 0) {
    // 			deficit.add(balance.getValue());
    // 		} else if (balance.getValue() > 0) {
    // 			surplus.add(balance.getValue());
    // 		}
    // 	}


    // 	//This is a closed system. Therefore if one queue is emptied other one should ideally be empty;
    // 	int transactionCount = 0;
    // 	while (!surplus.isEmpty() && !deficit.isEmpty()) {
    // 		if (surplus.peek() + deficit.peek() > 0) {
    // 			int newSurplus = surplus.poll() + deficit.poll();
    // 			surplus.add(newSurplus);
    // 		} else {
    // 			int newDeficit = surplus.poll() + deficit.poll();
    // 			deficit.add(newDeficit);
    // 		}
    // 		transactionCount += 1;
    // 	}
    // 	return transactionCount;
    // }

    public List<Integer> computeBalances(int[][] transactions) {
    	int creditor;
    	int debtor;
    	int amount;
    	for (int i = 0; i < transactions.length; i++) {
    		creditor = transactions[i][0];
    		debtor = transactions[i][1];
    		amount = transactions[i][2];
    		balances.put(creditor, balances.getOrDefault(creditor, 0) - amount);
    		balances.put(debtor, balances.getOrDefault(debtor, 0) + amount);
    	}

    	/*
			Optimizations -  removing all 1-to-1 Transactions.
			eg A owes B 10 and both are not associated with any other transaction.
			And circular transactions;
    	*/
    	Map<Integer, Integer> optimizedBalances = new HashMap<>();
    	for (Map.Entry<Integer, Integer> entry : balances.entrySet()) {
    		optimizedBalances.put(entry.getValue(), optimizedBalances.getOrDefault(entry.getValue(), 0) + 1);
    	}

    	for (Map.Entry<Integer, Integer> entry : optimizedBalances.entrySet()) {
    		if (optimizedBalances.containsKey(-entry.getKey()) && optimizedBalances.get(-entry.getKey()) > 0) {
    			if (optimizedBalances.get(-entry.getKey()) > entry.getValue()) {
    				optimizedBalances.put(-entry.getKey(), optimizedBalances.get(-entry.getKey()) - entry.getValue());
    				optimizedTransactionCount += entry.getValue();
    				entry.setValue(0);
    			} else {
    				entry.setValue(entry.getValue() - optimizedBalances.get(-entry.getKey()));
    				optimizedTransactionCount += optimizedBalances.get(-entry.getKey());
    				optimizedBalances.put(-entry.getKey(), 0);
    			}
    		}
    	}
    	List<Integer> optimizedList = new ArrayList<>();
    	for (Map.Entry<Integer, Integer> entry : optimizedBalances.entrySet()) {
    		if (entry.getValue() > 0) {
    			for (int i = 0; i < entry.getValue(); i++) {
    				optimizedList.add(entry.getKey());	
    			}
    		}
    	}
    	//System.out.println(optimizedList);
    	return optimizedList;
    }
}
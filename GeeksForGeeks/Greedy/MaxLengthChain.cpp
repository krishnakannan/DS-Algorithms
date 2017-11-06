/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
The structure to use is as follows
struct val{
	int first;
	int second;
};*/
/*You are required to complete this method*/

//http://practice.geeksforgeeks.org/problems/max-length-chain/1

struct val* sort(struct val * p, int n);

int maxChainLen(struct val p[],int n) {
    val* sorted = (struct val *)malloc(n * sizeof(val));
    sorted = sort(p, n);
    int maxChain = 0;
    int prevChainIndex = 1;
    for (int i = 1; i < n; i++) {
        if (sorted[i].first > sorted[prevChainIndex].second) {
        	maxChain++;
        	prevChainIndex = i;
        }
    }
    return maxChain;
}

struct val* sort(struct val * p, int n) {
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (p[i].second < p[j].second) {
				val* temp = (struct val*)malloc(sizeof(val));
				temp->first = p[i].first;
				temp->second = p[i].second;
				p[i].first = p[j].first;
				p[i].second = p[j].second;
				p[j].first = temp->first;					
				p[j].second = temp->second;					
			}
		}
	}
	return p;
}
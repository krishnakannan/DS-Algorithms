/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*
Structure of the node of the tree is as
struct Node
{
	int key;
	struct Node* left, *right;
};
*/
// complete this function
// return true/false if the is Symmetric or not

//http://practice.geeksforgeeks.org/problems/symmetric-tree/1

bool checkSymmetry(struct Node* root1, struct Node* root2);

bool isSymmetric(struct Node* root) {
	return checkSymmetry(root->left, root->right);
}

bool checkSymmetry(struct Node* root1, struct Node* root2) {
    if (root1 == NULL && root2 == NULL)  {
	    return true;
	}
	
	if (root1 != NULL && root2 != NULL) {
	    return root1->key == root2->key && checkSymmetry(root1->left, root2->right) 
	        && checkSymmetry(root1->right, root2->left);
	}
	 
	return false;
}
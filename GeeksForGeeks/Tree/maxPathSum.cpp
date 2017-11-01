/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/*Complete the function below
Node is as follows
struct Node{
    int data;
    Node *left, *right;
};
*/

//http://practice.geeksforgeeks.org/problems/maximum-path-sum/1

int maxPath(struct Node * root);
int max (int a, int b);
int maxSum = 0;
int maxPathSum(struct Node *root)
{
    if (root == NULL) {
        return 0;
    }
    maxSum = 0;
    maxPath(root);
    return maxSum;
}

int maxPath(struct Node * root) {
    if (root == NULL) {
        return 0;
    } else if (root->left == NULL && root->right == NULL) {
        return root->data;
    } 
    
    int left = maxPath(root->left);
    int right = maxPath(root->right);
    maxSum = maxSum < root->data + left + right ? root->data + left + right : maxSum;
    return root->data + max(left, right);
}

int max (int a, int b) {
    return a > b ? a : b;
}
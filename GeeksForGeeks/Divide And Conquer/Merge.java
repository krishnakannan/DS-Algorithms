/*
Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* The task is to complete merge() which is used
in below mergeSort() */
class GfG
{
   // Merges two subarrays of arr[].  First subarray is arr[l..m]
   // Second subarray is arr[m+1..r]
    void merge(int arr[], int l, int m, int r)
    {
         int[] arr1 = new int[m - l + 1];
         int[] arr2 = new int[r - m];
         for (int i = 0; i < arr1.length; i++) {
             arr1[i] = arr[i + l];
         }
         for (int i = 0; i < arr2.length; i++) {
             arr2[i] = arr[m + 1 + i];
         }
         
         int i = 0;
         int j = 0;
         int k = l;
         while (i < arr1.length && j < arr2.length) {
             if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                k++;
                i++;
             } else if (arr1[i] >= arr2[j]) {
                arr[k] = arr2[j];
                k++;
                j++;
             }
         }
         while (i < arr1.length) {
             arr[k] = arr1[i];
             k++;
             i++;
         }
         while (j < arr2.length) {
             arr[k] = arr2[j];
             k++;
             j++;
         }
    }
}
 /* This method is present in a class other than GfG class .
static void mergeSort(int arr[], int l, int r)
 {
    GfG g = new GfG();
    if (l < r)   
   {
        int m = (l+r)/2;
        mergeSort(arr, l, m);
        mergeSort(arr , m+1, r);
        g.merge(arr, l, m, r);
    }
}*/
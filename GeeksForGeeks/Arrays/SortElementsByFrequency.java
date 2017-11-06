import java.util.*;
import java.lang.*;
import java.io.*;

//http://practice.geeksforgeeks.org/problems/sorting-elements-of-an-array-by-frequency/0

class SortElementsByFrequency {
	public static void main (String[] args) {
		Scanner in = new Scanner(System.in);
		int testcases = in.nextInt();
		SortElementsByFrequency sebf = new SortElementsByFrequency();
		while (--testcases >= 0) {
		    int n = in.nextInt();
		    int[] arr = new int[n];
		    for (int i = 0; i < arr.length; i++) {
		        arr[i] = in.nextInt();
		    }
			sebf.getElements(arr);
			System.out.println();
 		}
	}

	public void getElements(int[] arr) {
		//Upper Bound is 60
		KeyValue[] kvArr = new KeyValue[61];
		for (int i = 0; i < 61; i++) {
			kvArr[i] = new KeyValue(i, 0);
		}
		for (int i = 0; i < arr.length; i++) {			
			kvArr[arr[i]].v++;
		}
		// for (int i = 0; i < 61; i++) {
		// 	System.out.println("Key  = " + kvArr[i].k  + " Valu = " + kvArr[i].v);
		// }

		sort(kvArr);
		for (int i = 0; i < kvArr.length; i++) {
			KeyValue temp = kvArr[i];
			while (--temp.v >= 0) {
				System.out.print(temp.k + " ");
			}
		}
	} 

	public void sort(KeyValue[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i].v < arr[j].v && i < j) {
					KeyValue temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				} else if (arr[i].v == arr[j].v && i < j) {
					if (arr[i].k > arr[j].k) {
						KeyValue temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
		}
	}

	class KeyValue {
		public int k;
		public int v;
		public KeyValue() {}
		public KeyValue(int k, int v) {
			this.k = k;
			this.v = v;
		}		
	}
}
package org.mge.ds.arrays;

/**
 * Algorithm:
 * 
 * Querying length of longest is fairly easy. Note that we are dealing with end
 * elements only. We need not to maintain all the lists. We can store the end
 * elements in an array. Discarding operation can be simulated with replacement,
 * and extending a list is analogous to adding more elements to array.
 * 
 * We will use an auxiliary array to keep end elements. The maximum length of
 * this array is that of input. In the worst case the array divided into N lists
 * of size one (note that it does’t lead to worst case complexity). To discard
 * an element, we will trace ceil value of A[i] in auxiliary array (again
 * observe the end elements in your rough work), and replace ceil value with
 * A[i]. We extend a list by adding element to auxiliary array. We also maintain
 * a counter to keep track of auxiliary array length.
 * 
 * 1. If A[i] is smallest among all end candidates of active lists, we will
 * start new active list of length 1.
 * 
 * 2. If A[i] is largest among all end candidates of active lists, we will clone
 * the largest active list, and extend it by A[i].
 * 
 * 3. If A[i] is in between, we will find a list with largest end element that
 * is smaller than A[i]. Clone and extend this list by A[i]. We will discard all
 * other lists of same length as that of this modified list.
 **/
public class LongestIncreasingSubSequence {
	public static void main(String[] args) {
		int[] a = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
		System.out.println("Length of Longest Increasing Subsequence is "
				+ findLISLength(a));
	}

	static int findLISLength(int a[]) {
		int n = a.length;
		int[] tailTable = new int[n];
		int len = 1;
		tailTable[0] = a[0];

		for (int i = 1; i < n; i++) {
			if (a[i] < tailTable[0]) {
				tailTable[0] = a[i];
			} else if (a[i] > tailTable[len - 1]) {
				tailTable[len++] = a[i];
			} else {
				int index = ceilIndex(tailTable, 0, len - 1, a[i]);
				tailTable[index] = a[i];
			}
		}

		return len;
	}

	static int ceilIndex(int[] a, int l, int h, int key) {
		while ((h - l) > 1) {
			int m = (l + h) / 2;

			if (key > a[m]) {
				l = m + 1;
			} else {
				h = m - 1;
			}
		}
		return h;
	}
}

package org.mge.algos.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * 
 * This problem is a variation of standard Longest Increasing Subsequence problem. Following is a simple two step process.
 1) Sort given pairs in increasing order of first (or smaller) element. Why do not need sorting? Consider the example {{6, 8}, {3, 4}} to understand the need of sorting. If we proceed to second step without sorting, we get output as 1. But the correct output is 2.
 2) Now run a modified LIS process where we compare the second element of already finalized LIS with the first element of new LIS being constructed.
 * 
 */

public class MaxLengthChainOfPairs {

	public static void main(String[] args) {
		int[][] arr = { { 5, 24 }, { 39, 60 }, { 15, 28 }, { 27, 40 },
				{ 50, 90 } };

		List<Pair> pairs = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			pairs.add(new Pair(arr[i][0], arr[i][1]));
		}

		System.out.println(getMaxLength(pairs));
	}

	static int getMaxLength(List<Pair> pairs) {
		if (pairs == null || pairs.size() == 0) {
			return 0;
		}
		int n = pairs.size();
		Collections.sort(pairs, new Comparator<Pair>() {
			public int compare(Pair p1, Pair p2) {
				return p1.x.compareTo(p2.x);
			}
		});

		int mcl[] = new int[n];

		for (int i = 0; i < n; i++) {
			mcl[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (pairs.get(j).y < pairs.get(i).x && mcl[i] < mcl[j] + 1) {
					mcl[i] = mcl[j] + 1;
				}
			}
		}

		int max = -1;

		for (int i : mcl) {
			if (max < i) {
				max = i;
			}
		}
		return max;
	}

	static class Pair {
		Integer x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}

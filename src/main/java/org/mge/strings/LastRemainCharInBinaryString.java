package org.mge.strings;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 
 * Given a binary string str consisting of only 0’s and 1’s. The following two operations can be performed on it:

 1. One digit can delete another digit i.e. a 0 can delete a 1 and vice versa.
 2. If at any moment, the entire string consists only 0’s or 1’s, then the respective digit is printed.
 The task is to print the remaining digit which will be left at the end.
 */

public class LastRemainCharInBinaryString {
	public static void main(String[] args) {
		String str = "0010";
		System.out.println(remainingCharacter(str));
	}

	static char remainingCharacter(String str) {
		char c[] = str.toCharArray();
		Queue<Integer> q = new LinkedList<>();
		int[] count = new int[2];
		int[] del = new int[2];
		for (int i = 0; i < c.length; i++) {
			int x = c[i] == '1' ? 1 : 0;
			q.add(x);
			count[x]++;
		}

		while (count[0] > 0 && count[1] > 0) {
			int t = q.poll();

			if (del[t] > 0) {
				del[t]--;
				count[t]--;
			} else {
				del[t ^ 1]++;
				q.add(t);
			}
		}

		if (count[0] > 0) {
			return '0';
		}

		return '1';
	}
}

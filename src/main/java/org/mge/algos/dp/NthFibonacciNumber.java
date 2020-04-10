package org.mge.algos.dp;

public class NthFibonacciNumber {

	static int[] memTable = new int[90];

	public static void main(String[] args) {
		int n = 50;
		long startTime = System.currentTimeMillis();
		System.out.println(getNthFN(n));

		System.out.println("Time taken for recursion: "
				+ (System.currentTimeMillis() - startTime) / 1000d + " Sec");
		
		

		startTime = System.currentTimeMillis();
		for (int i = 0; i < 90; i++) {
			memTable[i] = -1;
		}
		System.out.println(getNthFNMem(n));
		System.out.println("Time taken for memoization: "
				+ (System.currentTimeMillis() - startTime) / 1000d + " Sec");
		
		
		
		startTime = System.currentTimeMillis();
		System.out.println(getNthFNTab(n));

		System.out.println("Time taken for tabulation: "
				+ (System.currentTimeMillis() - startTime) / 1000d + " Sec");


	}

	public static int getNthFN(int n) {
		if (n <= 1) {
			return n;
		}

		return getNthFN(n - 1) + getNthFN(n - 2);
	}

	public static int getNthFNMem(int n) {
		if (memTable[n] == -1) {

			if (n <= 1) {
				memTable[n] = n;
			} else {
				memTable[n] = getNthFNMem(n - 1) + getNthFNMem(n - 2);
			}
		}
		return memTable[n];
	}
	
	public static int getNthFNTab(int n) {
		int[] table = new int[n+1];
		
		table[0] = 0;
		table[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			table[i] = table[i-1] + table[i-2];
		}
		
		return table[n];
	}

}

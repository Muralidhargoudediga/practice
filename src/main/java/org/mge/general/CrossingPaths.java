package org.mge.general;

public class CrossingPaths {

	public static void main(String[] args) {
		int[] A = {0, 1, 0, 1, 1, 0, 1, 1, 1, 0};
		System.out.println(solution(A));
	}
	
	/**
	 * Logic: 
	 * 1. For each 0(hiker going up) count no.of 1's(hiker going down) after this 0 and store the count at this index.
	 * 2. Loop through the array again and add all the elements to get the result.
	 * 
	 * @param A
	 * @return no. of pairs crossing paths
	 */
	public static int solution(int[] A) {
		
		if(A == null || A.length == 0 || A.length == 1) {
			return 0;
		}
		
		int count = 0;
		for(int i = A.length - 1; i >= 0; i--) {
			if(A[i] == 1) {
				count++;
				A[i] = 0;
			} else {
				A[i] = count;
			}
		}
		
		int noOfCrossingPairs = 0;
		for(int i : A) {
			noOfCrossingPairs += i;
			if(noOfCrossingPairs >= 1000000000) {
				return -1;
			}
		}
		
		return noOfCrossingPairs;
	}
}

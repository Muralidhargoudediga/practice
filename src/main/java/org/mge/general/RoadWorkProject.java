package org.mge.general;

public class RoadWorkProject {

	public static void main(String[] args) {
		//int[] A = {5, 3, 4, 4, 2, 3, 1, 4};
		int[] A = {1, 2, 3, 3, 2, 1};
		
		System.out.println(getWorkCompletionMonth(A, 3));
	}
	
	/**
	 * Logic :
	 * 1. Create a boolean array with length X.
	 * 2. Loop through the array and mark the segment in boolean array to true(completed) and update the result month variable
	 * 3. Loop through the boolean array to check all the segments are completed. If yes return the result month. Return -1 otherwise.
	 * @param A - Input Array
	 * @param X - No. of segments
	 * @return month of completion
	 */
	public static int getWorkCompletionMonth(int[] A, int X){
		if(A == null || A.length == 0) {
			return -1;
		}
		boolean[] segments = new boolean[X];
		int completionMonth = -1;
		for(int i = 0; i < A.length; i++) {
			if(A[i] <= X) {
				if(!segments[A[i]-1]) {
					completionMonth = i;
					segments[A[i]-1] = true;
				}
			}
		}
		
		for(boolean flag : segments) {
			if(!flag) {
				return -1;
			}
		}
		
		return completionMonth;
	}

}

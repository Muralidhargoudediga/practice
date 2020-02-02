package org.mge.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSumClosestToZero {
	public static void main(String[] args) {
		int[] arr = {-3, -4, -1, -2};
		printResult(getPairs(arr));
	}
	
	public static void printResult(List<Pair> pairs){
		for(Pair pair : pairs){
			System.out.println(pair.getX() + " " + pair.getY());
		}
	}
	
	public static List<Pair> getPairs(int[] arr){
		Arrays.sort(arr);
		
		List<Pair> pairs = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		int i = 0, j = arr.length - 1;
		
		while(i < j){
			int s = Math.abs(arr[i] + arr[j]);
			
			if(s < min){
				min = s;
				pairs.clear();
				pairs.add(new Pair(arr[i], arr[j]));
			} else if(s == min){
				pairs.add(new Pair(arr[i], arr[j]));
			}
			
			if(arr[i] + arr[j] < 0) {
				i++;
			} else {
				j--;
			}
		}
		
		return pairs;
	}
	
	public static class Pair {
		int x, y;

		public Pair(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}
	
//	  @Test
//	  public void listOfPairsWithMinSumTest() {
//	    assertEquals(Arrays.asList(Pair.of(-3, 3), Pair.of(-2, 2)), listOfPairsWithMinSum(new int[]{-3, 5, 4, 3, -2, 1, 2}));
//	    assertEquals(Collections.singletonList(Pair.of(1, 2)), listOfPairsWithMinSum(new int[]{3, 4, 1, 2}));
//	    assertEquals(Collections.singletonList(Pair.of(-2, -1)), listOfPairsWithMinSum(new int[]{-3, -4, -1, -2}));
//	  }
}

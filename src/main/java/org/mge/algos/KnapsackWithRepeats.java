package org.mge.algos;

public class KnapsackWithRepeats {

	public static void main(String[] args) {
		int w[] = { 1, 50 };
		int v[] = { 1, 30 };
		int W = 100;
		System.out.println(maxValue(w, v, W));
	}
	
	public static double maxValue(int w[], int v[], int W) {
		int V[] = new int[W + 1];
		for(int i = 0; i <= W; i++){
			for(int j = 0; j < w.length; j++) {
				if(i>=w[j]) {
					int value = V[i-w[j]] + v[j];
					if(V[i] < value)
						V[i] = value;
				}
			}
		}
		return V[W];
	}
	
	public static void backTrack(int w[], int v[], int W, int V[]) {
		int n = V.length;
		
		while(n > 0 && V[n] > 0) {
			if()
		}
	}

}

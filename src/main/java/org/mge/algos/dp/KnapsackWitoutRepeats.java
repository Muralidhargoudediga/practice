package org.mge.algos;

public class KnapsackWitoutRepeats {

	public static void main(String[] args) {
		int[] w = {6, 3, 4, 2};
		int[] v = {30, 14, 16, 9};
		System.out.println(maxValue(w, v, 10));
	}
	
	public static int maxValue(int w[], int v[], int W) {
		int[][] V = new int[W+1][w.length + 1];
		for(int i=0; i<=w.length;i++){
			for(int j=0; j<=W ; j++){
				if(i == 0 || j== 0) {
					V[j][i] = 0;
					continue;
				}
				V[j][i] = V[j][i-1];
				if(w[i-1] <= j){
					int value = V[j-w[i-1]][i-1] + v[i-1];
					if(value > V[j][i]) {
						V[j][i] = value;
					}
				}
			}
		}
		backTrack(w, v, W, V);	
		return V[W][w.length];
	}
	
	static void backTrack(int w[], int v[], int W, int[][] V){
		int j = w.length;
		int i = W;
		int[] track = new int[w.length];
		while(i > 0 && j > 0) {
			if(V[i][j] == V[i][j-1]) {
				j--;
			} else if(V[i][j] == (V[i-w[j-1]][j-1] + v[j-1])) {
				i = i - w[j-1];
				track[j-1] = 1;
				j--;
			}
		}
		
		for(int k = 0; k< track.length; k++) {
			if(track[k] == 1) {
				System.out.println("Item " + k + " is used");
			}
		}
	}
}

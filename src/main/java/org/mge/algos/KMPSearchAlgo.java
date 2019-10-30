package org.mge.algos;

public class KMPSearchAlgo {
	public static void kmpSearch(String text, String pat) {
		int lps[] = new int[pat.length()];
		computeLPSArray(pat, lps);
		int i=0, j=0;
		while(i<text.length()) {
			if(text.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if(j == pat.length()) {
					System.out.println("Pattern found at index : " + (i - j));
					j=lps[j-1];
				}
			} else {
				if(j !=0 )
					j = lps[j-1];
				else
					i++;
			}
			
		}
	}
	
	static void computeLPSArray(String str, int[] lps) {
		int i = 1, j=0;
		lps[0]=0;
		while(i<str.length()) {
			if(str.charAt(i) == str.charAt(j)) {
				j++;
				lps[i]=j;
				i++;
			} else {
				if(j != 0) {
					j = lps[j-1];
				} else {
					lps[i] = j;
					i++;
				}
			}
		}
	}
}

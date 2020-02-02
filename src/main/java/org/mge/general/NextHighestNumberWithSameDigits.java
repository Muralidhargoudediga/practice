package org.mge.general;

import java.util.Arrays;

public class NextHighestNumberWithSameDigits {
	public static void main(String[] args) {
		String n = "4765";
		
		char[] ch = n.toCharArray();
		
		int i = n.length() - 1;
		while(i > 0 && ch[i] < ch[i-1]) {
			i--;
		}
		
		if(i == 0) {
			System.out.println("Not Possible");
			return;
		}
		
		int x = ch[i-1], min = i;
		
		for(int j = i+1; j < n.length(); j++) {
			if(ch[j] > x && ch[j] < ch[min]) {
				min = j;
			}
		}
		
		char t = ch[min];
		ch[min] = ch[i-1];
		ch[i-1] = t;
		
		Arrays.sort(ch, i, n.length());
		
		System.out.println(new String(ch));
	}
}
